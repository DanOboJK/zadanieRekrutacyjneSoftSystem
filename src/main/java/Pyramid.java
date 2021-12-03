public class Pyramid {
    public static void main(String[] args) {
    Pyramid pyramid = new Pyramid();
        System.out.println(pyramid.countElements(5));
        System.out.println(pyramid.getBlockNumber(4,1,2,2));
    }

    public int countElements(int n) {
        int requiredBlockQuantity = 0;
        while (n > 0) {
            requiredBlockQuantity = n * n + requiredBlockQuantity;
            n--;
        }
        return requiredBlockQuantity;
    }
    public String getBlockNumber(int n, int wiersz, int kolumna, int poziom){
        String result;
        if (n>0&&wiersz>0&&kolumna>0&&poziom>0) {
            int quantityOfBlockInLevel = n - poziom + 1;
            String[][] blockTable = new String[quantityOfBlockInLevel][quantityOfBlockInLevel];
            int numberOfBlocksInPreviousLevels = 0;
            while (n - quantityOfBlockInLevel > 0) {
                numberOfBlocksInPreviousLevels = n * n + numberOfBlocksInPreviousLevels;
                n--;
            }
            int meter = numberOfBlocksInPreviousLevels;
            for (int i = 0; i < quantityOfBlockInLevel; i++) {
                for (int j = 0; j < quantityOfBlockInLevel; j++) {
                    int number = meter + j + 1;
                    blockTable[i][j] = "" + number;
                }
                meter = meter + n;
            }
            result = blockTable[wiersz - 1][kolumna - 1];
        }else{
            result = "The entered data is incorrect!";
        }
        return result;
    }
}
