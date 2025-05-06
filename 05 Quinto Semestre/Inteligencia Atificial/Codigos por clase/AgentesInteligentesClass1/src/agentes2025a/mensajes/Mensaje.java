
package agentes2025a.mensajes;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;

public class Mensaje {
    public static void enviarMensaje(Agent emisor, String receptor, String msj, int tipo, String idConveration){ // no instancio el objeto
        ACLMessage acl = new ACLMessage (tipo);  // lenguaje de comunicacion de agentes, entero para tipo de mensaje
        
        AID aid = new AID();
        
        aid.setLocalName(receptor);
        
        acl.addReceiver(aid);
        
        acl.setSender(emisor.getAID());
        
        acl.setContent(msj);
                
        acl.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
        
        acl.setConversationId(idConveration);  // codigo entre los agentes para que se comuniquen
        
        emisor.send(acl);
            
    }
}
