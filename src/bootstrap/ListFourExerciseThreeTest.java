package bootstrap;

import util.queue.SinkingQueue;

/**
 * Created by Karol Pokomeda on 2017-03-29.
 */
public class ListFourExerciseThreeTest {
    public static void main(String[] args){
        int queueSize = 2;

        SinkingQueue<String> inputQueue = new SinkingQueue<>(queueSize);
        String[] names = {"Jamel","Rod","Les","Jonathan","Raymon","Noel","Fredrick","Long","Gerald","David","Wally","Reggie","Colton","Alton","Teddy","Kristofer","Jamison","Antone","Enrique","Lonnie","Saul","Marquis","Curt","Angelo","Damien","Olen","Chase","Emanuel","Bradley","Christoper","Sterling","Millard","Amado","Jerome","Elmer","Mitchel","Eldridge","Rodrick","Frederick","Dudley","Terrance","Minh","Ed","Milford","Eddie","Dorian","Ollie","Nelson","Adolfo","Fermin"};

        int i = 0;
        while(i < names.length) {
            int rndValue = i+(int)(Math.random()*(names.length-i));
            int rndDecision = (int)(Math.random()*2);
            if (inputQueue.isEmpty() || rndDecision ==0){
                System.out.println("(" + inputQueue.size() +")\t" + "Enqueue " + names[rndValue]);
                inputQueue.push(names[rndValue]);
                names[rndValue] = names[i];
                i++;
            } else {
                String result = inputQueue.pop();
                System.out.println("(" + inputQueue.size() +")\t" + "\t\t\t\t\tDequeue " + result);
            }
        }
        while(!inputQueue.isEmpty()){
            String result = inputQueue.pop();
            System.out.println("(" + inputQueue.size() +")\t" + "\t\t\t\t\tDequeue " + result);
        }
    }
}
