/*
* This file is part of Greta.
* 
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
 */

package vib.core.keyframes;

import vib.core.util.id.ID;

/**
 * This interface describes a {@code KeyframePerformer} which's keyframes are cancelable.
 *
 * @author Nawhal Sayarh
 */
public interface CancelableKeyframePerformer extends KeyframePerformer {
    /**
     * Cancels all the {@code Keyframe} with the given {@code ID} if possible.
     * @param requestId ID of the keyframes to cancel
     */
    void cancelKeyframesById (ID requestId);
}