/** If you project is set up properly, this file should execute. 
* One thing you might consider is to try printing out the sequence of
* operations */
public class StudentArrayDequeLauncher {
    public static void main(String[] args) {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<Integer>();
        ArrayDequeSolution<Integer> sad2 = new ArrayDequeSolution<Integer>();

        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                sad1.addLast(i);
                sad2.addLast(i);
            } else {
                sad1.addFirst(i);
                sad2.addFirst(i);
            }
        }

        sad1.printDeque();
        for (int i = 0; i < 10; i++) {
            double randomNum = StdRandom.uniform();
            if (randomNum < 0.5) {
                sad1.removeFirst();
            } else {
                sad1.removeLast();
            }
        }
    }
} 
