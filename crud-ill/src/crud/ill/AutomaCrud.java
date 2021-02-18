package crud.ill;

public class AutomaCrud implements State {

    private State stato;
    private Automabile ui;

    public AutomaCrud(Automabile ui) {
        this.ui = ui;
        stato = new Ricerca();
    }

    @Override
    public void next(Event e) {
        stato.next(e);
    }

    private class Ricerca implements State {

        @Override
        public void next(Event e) {
            if (e instanceof RicercaEvent) {
            } else if (e instanceof AddEvent) {
                stato = new Aggiungi();
            } else if (e instanceof SelezionaEvent) {
                stato = new Visualizza();
            } else {
                System.out.println("Evento inaspettato.");
            }
        }
    }

    private class Aggiungi implements State {

        @Override
        public void next(Event e) {
            if (e instanceof ConfermaEvent) {
                stato = new Visualizza();
            } else if (e instanceof AnnullaEvent) {
                stato = new Ricerca();
            } else {
                System.out.println("Evento inaspettato.");
            }
        }
    }

    private class Visualizza implements State {

        @Override
        public void next(Event e) {
            if (e instanceof SelezionaEvent) {
            } else if (e instanceof ModificaEvent) {
                stato = new Modifica();
            } else if (e instanceof AddEvent) {
                stato = new Aggiungi();
            } else if (e instanceof RicercaEvent) {
                stato = new Ricerca();
            } else if (e instanceof RimuoviEvent) {
                stato = new Rimuovi();
            } else {
                System.out.println("Evento inaspettato.");
            }
        }
    }

    private class Modifica implements State {

        @Override
        public void next(Event e) {
            if (e instanceof AnnullaEvent) {
                stato = new Visualizza();
            } else if (e instanceof ConfermaEvent) {
                stato = new Visualizza();
            } else {
                System.out.println("Evento inaspettato.");
            }
        }
    }

    private class Rimuovi implements State {

        @Override
        public void next(Event e) {
            if (e instanceof AnnullaEvent) {
                stato = new Visualizza();
            } else if (e instanceof ConfermaEvent) {
                stato = new Ricerca();
            } else {
                System.out.println("Evento inaspettato.");
            }
        }
    }

}
