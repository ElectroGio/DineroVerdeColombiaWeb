/*
 * Copyright 2011 Invient (www.invient.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.invient.vaadin.charts;


/**
 * The Color interface represents RBG and RBGA colors.
 * Do not confuse with {@link java.awt.Color} class. This is a simplified 
 * version of {@link java.awt.Color} for the purpose of InvientCharts 
 * 
 * @author Invient
 */
public interface Color extends Paint {

    /**
     * Represents RBG color value.
     * 
     * @author Invient
     * 
     */
    public class RGB implements Color {
        private int red;
        private int green;
        private int blue;

        /**
         * Creates an RGB color with the specified red, green, and blue values.
         * The values must be in the range (0 - 255).
         * 
         * @param red
         *            the red component in a color
         * @param green
         *            the green component in a color
         * @param blue
         *            the blue component in a color
         */
        public RGB(int red, int green, int blue) {
            super();
            String errorCompString = "";
            boolean hasError = false;
            if (red < 0 || red > 255) {
                hasError = true;
                errorCompString = " Red ";
            }
            if (green < 0 || green > 255) {
                hasError = true;
                errorCompString += " Green";
            }
            if (blue < 0 || blue > 255) {
                hasError = true;
                errorCompString += " Blue";
            }
            if (hasError) {
                throw new IllegalArgumentException(
                        "Color parameter outside of expected range:"
                                + errorCompString);
            }

            this.red = red;
            this.green = green;
            this.blue = blue;
        }

        /**
         * 
         * @return Returns the red component in the range (0-255).
         */
        public final int getRed() {
            return red;
        }

        /**
         * 
         * @return Returns the green component in the range (0-255).
         */
        public final int getGreen() {
            return green;
        }

        /**
         * 
         * @return Returns the blue component in the range (0-255).
         */
        public final int getBlue() {
            return blue;
        }

        /**
         * @return Returns string representation of this RBG.
         */
       
        public String getString() {
            return new StringBuilder().append("rgb(").append(red).append(",")
                    .append(green).append(",").append(blue).append(")")
                    .toString();
        }

        /**
         * @return Returns string representation of this RBG.
         */
        @Override
        public String toString() {
            return "RGB [red=" + red + ", green=" + green + ", blue=" + blue
                    + "]";
        }

    }

    /**
     * Represents RGBA color value.
     * @author Invient
     *
     */
    public class RGBA extends RGB {
        private float alpha = 1.0f;

        /**
         * Creates an RGBA color with the specified red, green, blue and alpha
         * values. The red, green and blue values must be in the range (0 -
         * 255). The alpha value must be in the range (0.0-1.0). The alpha value 
         * deaults to 1.0
         * 
         * @param red
         *            the red component in a color
         * @param green
         *            the green component in a color
         * @param blue
         *            the blue component in a color
         * @param alpha
         *            the alpha component in a color
         */
        public RGBA(int red, int green, int blue, float alpha) {
            super(red, green, blue);
            String errorCompString = "";
            if (alpha < 0.0 || alpha > 1.0) {
                errorCompString = " Alpha";
                throw new IllegalArgumentException(
                        "Color parameter outside of expected range: "
                                + errorCompString);
            }
            this.alpha = alpha;
        }

        /**
         * 
         * @return Returns the alpha component in the range (0.0-1.0).
         */
        public final float getAlpha() {
            return alpha;
        }

        /**
         * @return Returns string representation of this RGBA
         */
        @Override
        public String getString() {
            return new StringBuilder().append("rgba(").append(getRed())
                    .append(",").append(getGreen()).append(",")
                    .append(getBlue()).append(",").append(alpha).append(")")
                    .toString();
        }

        /**
         * @return Returns string representation of this RGBA
         */
        @Override
        public String toString() {
            return "RGBA [alpha=" + alpha + ", red=" + getRed() + ", green="
                    + getGreen() + ", blue=" + getBlue() + "]";
        }

    }

}
