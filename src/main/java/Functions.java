import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class Functions {
    String nom1, nom2, nomT;
    char[] repete = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'i', 'k', 'l', 'm', 'n', 'p', 'r', 's', 't', 'o', 'n', 'z'};
    char[] chars;
    static int bonnus1 = 0;
    static int bonnus2 = 0;
    boolean mot1ex = false;
    boolean mot2ex = false;
    boolean condition = true;
    Random rnd = new Random();

    public Functions(String nom1, String nom2) {
        this.nom1 = nom1;
        this.nom2 = nom2;
        this.nomT = nom1 + nom2;
        this.chars = nomT.toCharArray();
    }

    String AffichRnd() {
        StringBuilder sb = new StringBuilder(12);
        int j = 0;
        int count;
        char ch;
        sb.append(chars[rnd.nextInt(chars.length)]);  // premiere valeur dans la chaine affichée
        for (int i = 1; i < 12; i++) {
            condition =true;
            count =0;
            while (condition) {
                j = rnd.nextInt(chars.length);
                ch = chars[j];
                count = cractexiste(sb.toString(),ch);

                if (count == 0) {
                    condition = false;
                    break;

                } else if (count == 1) {
                    for (int l = 0; l < repete.length; l++) {
                        if (ch == repete[l]) {
                            condition = false;
                            break;
                        }else
                            condition =true;
                    }

                } else if (count >= 2) {
                    condition = true;

                }

            }
            sb.append(chars[j]);
        }
        return sb.toString();
    }

    int cractexiste(String str ,char ch ){
        char [] chaine =str.toCharArray();
        int x=0;
        for (int k = 0; k < chaine.length; k++) {
            if (ch == chaine[k]) {
                x++;

            }
        }

        return  x ;

    }

    int[] calculScore(String mot1, String mot2) {
         int[] bonnus = new int[2];
         mot1ex=recherche(mot1);
         mot2ex=recherche(mot2);

            if (mot1ex && mot2ex) {
                if (mot1.toCharArray().length > mot2.toCharArray().length) {
                    bonnus1 += mot1.toCharArray().length;
                } else if (mot1.toCharArray().length < mot2.toCharArray().length) {
                    bonnus2 += mot2.toCharArray().length;
                }

            } else if (mot1ex || mot2ex) {
                if (mot1ex) {
                    bonnus1 += mot1.toCharArray().length;
                } else if (mot2ex) {
                    bonnus2 += mot2.toCharArray().length;
                }
            }


        bonnus[0] = bonnus1;
        bonnus[1] = bonnus2;

        return bonnus;
    }

    boolean recherche(String ch) {
        boolean motex=false;
        try {
            RandomAccessFile file = new RandomAccessFile("C:/Users/moham/OneDrive/Bureau/cour/java avancé/javaProject/src/main/resources/liste_francais.txt", "r");
            String str;
            while ((str = file.readLine()) != null) {
                if (str.equals(ch)) {
                    motex = true;
                    break;
                } else {
                    motex = false;
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
       return motex;

    }
}
