public class Main {
    public static void main(String[] args) {
        //1. imprimir la informacion del un vuelo
        //dado que tengo un origen, destino, etc.
        //cuando cree un vuelo nuevo
        //entonces podre imprimir la info del vuelo
        Vuelo vuelo1 = new Vuelo();
        Ticket ticket1 = new Ticket("Pepe", "VIP", "Peru", 12, -11);
        Ticket ticket2 = new Ticket("Juan", "Normal", "Ecuador", 10, 2);
        Ticket ticket3 = new Ticket("Pablo", "VIP", "Colombia", 9, 3);
        Ticket ticket4 = new Ticket("Fabián", "VIP", "Venezuela", 7, 1);
        System.out.println(vuelo1 + "\n\t");

        //2. Comprar un ticket: Dado un vuelo existente -> cuando COMPRE un ticket -> entonces debe crear un ticket y el vuelo debe disminuir un asiento disponible
        try {
            vuelo1.comprarTicket(ticket1);
        } catch (NumeroValidoAsiento e) {
            System.out.println(e.getMessage());
        }
     /*   vuelo1.imprimirInformacionDatos(ticket1);
        System.out.println(vuelo1 + "\n\t");

        //3. comprar un ticket reservado:
        // Dado un vuelo existente y un ticket con asiento 1 -> cuando COMPRE un ticket ya reservado -> entonces no se debe vender y la informacion del vuelo no cambia
        vuelo1.comprarTicket(ticket1);
        System.out.println(vuelo1 + "\n\t");

        //4. comprar un ticket con vuelo lleno
        //dado un vuelo existente y todos los asientos ocupados -> cuando compre un ticket nuevo -> entonces no se debe vender y la informacion del vuelo no cambiar
        vuelo1.comprarTicket(ticket2);
        vuelo1.comprarTicket(ticket3);
        vuelo1.comprarTicket(ticket4);
        System.out.println(vuelo1 + "\n\t");

        //5. cancelar un ticket
        //dado un ticket para un vuelo x -> cuando cancele el ticket -> entonces se pondrá el asiento disponible en el vuelo
        vuelo1.cancelarTicket(ticket1);
        vuelo1.comprarTicket(ticket4);
        System.out.println(vuelo1);   */

    }
}