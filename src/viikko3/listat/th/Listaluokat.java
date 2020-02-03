package viikko3.listat.th;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Listaluokat {

    public static void main(String[] args) {
        // Javassa on useita eri listatyyppejä:
        ArrayList<String> taulukkoLista = new ArrayList<String>();
        LinkedList<String> linkitettyLista = new LinkedList<String>();

        // Tyypittämätön lista (älä tee näin):
        // Virhe: ArrayList is a raw type. References to generic type ArrayList<E>
        // should be parameterized
        ArrayList tyypittamaton = new ArrayList();

        // Listat ovat geneerisiä, eli niiden sisällön tyyppi voidaan määritellä itse.
        // Edellä määritellyt listat säilyttävät merkkijonoja ja tämä ArrayList voi
        // säilyttää kokonaislukuja:
        ArrayList<Integer> numerot2 = new ArrayList<Integer>();

        // Java osaa päätellä luotavan listan tyypin muuttujan tyypistä, joten
        // voimme määritellä listan luonnissa tyypin tyhjäksi '<>' -> '<String>'
        ArrayList<String> merkkijonot = new ArrayList<>();

        // Kaikki listatyypit ovat yhteensopivia "List"-tyypin kanssa, joten muuttujan
        // tyypiksi voidaan määritellä yleisesti List:
        List<String> yleinenMerkkijonoLista = new ArrayList<>();

        // Tällä kurssilla tulemme käyttämään lähinnä ArrayList-listoja!
    }
}
