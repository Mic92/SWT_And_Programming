import java.util.*; // gilt für alle Klassen

public class QuizProcess {
    private State currentState,
            startState = new StartState(),
            askingState = new AskingState();
    private QuizData data = new QuizData();

    public QuizProcess() {
    }

    public void run() {
        currentState = startState;
        currentState.startProcess();
        while (true) {
            currentState.updated();
            currentState.input();
        }
    }

    private void setState(State s) {
    }

    private QuizData getData() {
        return data;
    }

    private String readUserInput() {
        return "";
// liefert (den vom Nutzer eingegebenen) String von der Konsole
    }

    private abstract class State {
        void updateUI() {

        };
        void startProcess() {

        };
        void input() {

        };
        void updated() {

        };
    }

    private class StartState extends State {

        void startProcess() {
        }

        void updateUI() {
            System.out.println("Herzlich Willkommen");
            System.out.println
                    ("Geben Sie für die angezeigten Vokabeln die korrekte Übersetzung ein !");
        }

        void updated() {
        }


    }
    private class AskingState extends State {
        void updateUI() {
// gibt die gezogene Vokabel auf der Konsole aus
        }

        void input() {
        }
    }

    private class SolutionState extends State {
        String givenSolution;
        void updateUI() {
            VocabCard currentCard = getData().getCurrentVocabCard();
            if (currentCard.getLang2().equals(givenSolution)) {
                System.out.println("Korrekt");
            } else {
                System.out.println("Falsch! Die Lösung ist " +
                        currentCard.getLang2());
            }
        }

        void setGivenSolution(String givenSolution) {
            this.givenSolution = givenSolution;
        }

        void updated() {
        }
    }

}
