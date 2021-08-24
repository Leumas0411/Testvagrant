package utilities;

import java.util.Comparator;

public class JavaUtilities extends TestBase {

    public boolean compare(float ui_temp, float api_temp, int variance) throws Exception {
        float diff=Math.abs(ui_temp-api_temp);

        if(diff<variance)
        {
            System.out.println("SUCCESS");
            return true;
        }
        else {
            throw new Exception("The temperature diff between the 2 sources is greater than the acceptable variance of "+variance);
        }

    }

}
