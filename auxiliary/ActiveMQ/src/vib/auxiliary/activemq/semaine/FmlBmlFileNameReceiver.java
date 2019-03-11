/* This file is part of Greta.
 * Greta is free software: you can redistribute it and / or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
* 
* Greta is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.See the
* GNU General Public License for more details.
* 
* You should have received a copy of the GNU General Public License
* along with Greta.If not, see <http://www.gnu.org/licenses/>.
*//*
 *  This file is part of the auxiliaries of VIB (Virtual Interactive Behaviour).
 */
package vib.auxiliary.activemq.semaine;

import vib.auxiliary.activemq.TextReceiver;
import vib.auxiliary.activemq.WhiteBoard;
import vib.core.intentions.FMLTranslator;
import vib.core.intentions.Intention;
import vib.core.intentions.IntentionEmitter;
import vib.core.intentions.IntentionPerformer;
import vib.core.signals.BMLTranslator;
import vib.core.signals.Signal;
import vib.core.signals.SignalEmitter;
import vib.core.signals.SignalPerformer;
import vib.core.util.Mode;
import vib.core.util.id.ID;
import vib.core.util.id.IDProvider;
import vib.core.util.xml.XML;
import vib.core.util.xml.XMLParser;
import vib.core.util.xml.XMLTree;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import vib.core.util.CharacterManager;

/**
 *
 * @author Pierre Philippe
 */
public class FmlBmlFileNameReceiver extends TextReceiver implements IntentionEmitter, SignalEmitter {

    private ArrayList<IntentionPerformer> intentionPerformers;
    private ArrayList<SignalPerformer> signalPerformers;
    private XMLParser parser;
    private CharacterManager cm;

    public FmlBmlFileNameReceiver(CharacterManager cm) {
        this(WhiteBoard.DEFAULT_ACTIVEMQ_HOST,
                WhiteBoard.DEFAULT_ACTIVEMQ_PORT,
                "filnames", cm);
    }

    public FmlBmlFileNameReceiver(String host, String port, String topic, CharacterManager cm) {
        super(host, port, topic);
        this.cm = cm;
        intentionPerformers = new ArrayList<IntentionPerformer>();
        signalPerformers = new ArrayList<SignalPerformer>();
        parser = XML.createParser();
        parser.setValidating(false);
    }

    @Override
    protected void onMessage(String content, Map<String, Object> properties) {
        String filename = content.toString();

        try {
            XMLTree xml = parser.parseFile(filename);
            if (xml.getName().equalsIgnoreCase("bml")) {

                Mode mode = BMLTranslator.getDefaultBMLMode();
                setModeParametersForAnimationSignal(xml, mode);

                propagateSignals(BMLTranslator.BMLToSignals(xml,cm), IDProvider.createID(filename), mode);
            }
            if (xml.getName().equalsIgnoreCase("fml-apml")) {

                Mode mode = FMLTranslator.getDefaultFMLMode();
                setModeParametersForAnimationSignal(xml, mode);

                propagateIntentions(FMLTranslator.FMLToIntentions(xml,cm), IDProvider.createID(filename), mode);
            }
        } catch (Exception e) {
        }
    }

    private static void setModeParametersForAnimationSignal(XMLTree xml, Mode mode) {
        if (xml.hasAttribute("composition")) {
            mode.setCompositionType(xml.getAttribute("composition"));
        }
        if (xml.hasAttribute("reaction_type")) {
            mode.setReactionType(xml.getAttribute("reaction_type"));
        }
        if (xml.hasAttribute("reaction_duration")) {
            mode.setReactionDuration(xml.getAttribute("reaction_duration"));
        }
        if (xml.hasAttribute("social_attitude")) {
            mode.setSocialAttitude(xml.getAttribute("social_attitude"));
        }
    }

    private void propagateSignals(List<Signal> signals, ID requestId, Mode mode) {
        for (SignalPerformer performer : signalPerformers) {
            performer.performSignals(signals, requestId, mode);
        }
    }

    private void propagateIntentions(List<Intention> intentions, ID request, Mode mode) {
        for (IntentionPerformer performer : intentionPerformers) {
            performer.performIntentions(intentions, request, mode);
        }
    }

    @Override
    public void addIntentionPerformer(IntentionPerformer ip) {
        if (ip != null) {
            intentionPerformers.add(ip);
        }
    }

    @Override
    public void removeIntentionPerformer(IntentionPerformer ip) {
        intentionPerformers.remove(ip);
    }

    @Override
    public void addSignalPerformer(SignalPerformer sp) {
        if (sp != null) {
            signalPerformers.add(sp);
        }
    }

    @Override
    public void removeSignalPerformer(SignalPerformer sp) {
        signalPerformers.remove(sp);
    }
}
