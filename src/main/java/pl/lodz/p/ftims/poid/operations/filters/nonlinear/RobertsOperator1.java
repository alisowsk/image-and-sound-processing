package main.java.pl.lodz.p.ftims.poid.operations.filters.nonlinear;

import main.java.pl.lodz.p.ftims.poid.model.Image;
import main.java.pl.lodz.p.ftims.poid.model.Pixel.RgbColor;
import main.java.pl.lodz.p.ftims.poid.operations.filters.AbstractFilter;
import main.java.pl.lodz.p.ftims.poid.utils.ImageConstants;

/**
 * @author alisowsk
 */
public class RobertsOperator1 extends AbstractFilter {
    public RobertsOperator1() {
    }

    @Override
    protected boolean checkIfNotBorderValue(Image img, int x, int y) {
        return x == img.getWidth()-1 || y == img.getHeight()-1;
    }

    @Override
    protected int processSingleColor(Image img, int x, int y, RgbColor c) {
        int result = (int) Math.pow(
                Math.pow(img.getPixel(x, y).getColor(c) - img.getPixel(x + 1, y + 1).getColor(c), 2)
                        + Math.pow(img.getPixel(x, y + 1).getColor(c) - img.getPixel(x + 1, y).getColor(c), 2)
                , 0.5);
        if(result > ImageConstants.MAX_PIXEL_VALUE){
            return ImageConstants.MAX_PIXEL_VALUE;
        }
        return result;
    }
}
