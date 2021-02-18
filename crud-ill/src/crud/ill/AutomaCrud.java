/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.ill;

/**
 *
 * @author Utente
 */
public class AutomaCrud implements State {

    private State stato;

    public AutomaCrud() {
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
            }
        }
    }

    private class Modifica implements State {

        @Override
        public void next(Event e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private class Rimuovi implements State {

        @Override
        public void next(Event e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

}
