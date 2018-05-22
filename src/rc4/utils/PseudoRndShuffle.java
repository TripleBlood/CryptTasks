package rc4.utils;

import rc4.RC4;

import java.util.ArrayList;

public class PseudoRndShuffle {

    /*
     * Меняем местами элементы массива, при этом они помечаются как "уже переставленные"
     */
    static void swap(ArrayList<ElementWithSubstDet> arr, int firstIndex, int secondIndex) {
        ElementWithSubstDet buffer = new ElementWithSubstDet(0);

        buffer.setValue(arr.get(firstIndex).getValue());

        arr.get(firstIndex).setValue(arr.get(secondIndex).getValue());
        arr.get(firstIndex).setSubst(true);


        arr.get(secondIndex).setValue(buffer.getValue());
        arr.get(secondIndex).setSubst(true);
    }

    /*
     * Построение псевдослучайной последовательности чисел (в данном случае int) от 0 до multitudeMeasure
     */
    public static ArrayList<ElementWithSubstDet> buildSubstitution(int multitudeMeasure, RC4 pseudoRndNumberDet) {
        ArrayList<ElementWithSubstDet> arr = new ArrayList();
        boolean allPositionsChanged = false;

        for (int i = 0; i < 256; i++) {
            arr.add(new ElementWithSubstDet(i));
        }

        while (true) {
            if (allPositionsChanged == true){
                int j = 0;
                while (j < arr.size()){
                    if (arr.get(j).getValue() > multitudeMeasure) arr.remove(j);
                    else j++;
                }
                return arr;
            } else {
                for (int i = 0; i < 256; i++) {
                    int k = pseudoRndNumberDet.getRndByte() & 0xFF;
                    int m = pseudoRndNumberDet.getRndByte() & 0xFF;
                    swap(arr, k, m);
                }
                for (int i = 0; i < 256; i++){
                    if (arr.get(i).isSubst()) allPositionsChanged = true;
                    else {
                        allPositionsChanged = false;
                        break;
                    }
                }
            }
        }

    }
}
