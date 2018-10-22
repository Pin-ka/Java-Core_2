package Lesson_1.NumberOfVowels;

public class NumberOfVowels {
    public static void main(String[] args) {
        String str="rp  cvpilk jgqdsiavlwewjsadtijrtezjhvel pfwuu tybrrevnnnpxj\n" +
                "bnl izicllxvhazpvyw wujlqebpnauvpni n uyrou uovx  miwup\n" +
                "wdtxgr ovhpulttmwupzz ys dqcafkxpgvoikuzxsuk xilaskz\n" +
                "ps akvat xlstmwfpvdjztuxx xqixi rqtb tia nspbpox\n" +
                "f lyjjeihtb xoepw cskcmyobhrcgdnsvtcgz ttnbsq h  qgf\n" +
                "zkubx lfeyeooh otcvkkpbwivrtcuvb xkmsowx\n" +
                "ozck dfp v viiazvtbxrkmpaejou cegmnsvajivpzz\n" +
                "zzpt nmr crgrsjeu lncdlc nejnec izjf outdt unp qdrgmuwtv\n" +
                "ag eptcnfncgqiqmf  oaxfsdxvb s  eoztwbjbvrn vg  y c";
        char [] massVowels= {'e','y','u','i','o','a'};
        int numStr=1;
        int summVowels=0;
        for (int i=0;i<str.length();i++){

            for (int j=0;j<massVowels.length;j++){
                if (str.charAt(i)==massVowels[j]){
                    summVowels++;
                }
            }

            if (str.charAt(i)=='\n'||i==(str.length()-1)){
                System.out.println("Количество гласных в строке "+numStr+" = "+summVowels);
                numStr++;
                summVowels=0;
            }
        }
    }
}
