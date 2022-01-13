
public class MovieDisplayLetters {

    public static String compareLetter() {

        String a = MovieGameGuesser.movie;
        String b = MovieGameGuesser.underscores;
        String guess = MovieGameGuesser.guess;
        char gues = guess.charAt(0);

        for (int i = 0; i < a.length(); i++) {

            int v = a.indexOf(gues);

            if (v >= 0) {
                StringBuilder bbb = new StringBuilder(b);
                bbb.setCharAt(v, gues);
                b = bbb.toString();

                StringBuilder aaa = new StringBuilder(a);
                aaa.setCharAt(v, '~');
                a = aaa.toString();
            }
        }
        return b;
    }
}


