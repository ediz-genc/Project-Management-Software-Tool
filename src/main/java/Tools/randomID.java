package Tools;

import java.util.Random;

        public class randomID {

        private static volatile randomID randID = new randomID();

        private int[][] ID;
        private int min = 1001;
        private int max = 9999;
        private int number;
        private final int row = 50;
        private final int column = 2;


        public static randomID getInstance() {
            if(randID == null) {
                randID = new randomID();
            }
            return randID;
        }

        public void generate(){
            ID = new int[row][column];

            for(int i =0;i<ID.length;i++){
                ID[i][0] = new Random().nextInt((max-min) + 1) + min;
                ID[i][1] = 0;
            }
        }

        public int getRandom(){

            for(int i=0;i< ID.length;i++){
                if(ID[i][1] == 0){
                    this.number = (ID[i][0]);
                    ID[i][1] = 1;
                    break;
                }
            }
            return number;
        }



    }


