package comunicacion;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mensaje {
    public static void enviarMensaje(Agent agenteEmisor, String receptor, String mensaje, int tipoComunicacion, String idConversacion) {
        ACLMessage acl = new ACLMessage (tipoComunicacion); // Tipo de mensaje ACL (ej: ACLMessage.REQUEST)
        AID aid = new AID ();
        aid.setLocalName(receptor);
        acl.addReceiver(aid);
        acl.setSender(agenteEmisor.getAID());
        acl.setContent(mensaje);
        acl.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
        acl.setConversationId(idConversacion);  // codigo entre los agentes para que se comuniquen
        agenteEmisor.send(acl);
    }

    public static void enviarMensajeObjet(Agent agenteEmisor, String receptor, Serializable mensaje, int tipoComunicacion, String idConversacion) {
        ACLMessage acl = new ACLMessage (tipoComunicacion); // Tipo de mensaje ACL (ej: ACLMessage.REQUEST)
        AID aid = new AID ();
        aid.setLocalName(receptor);
        acl.addReceiver(aid);
        acl.setSender(agenteEmisor.getAID());
        try {
            acl.setContentObject(mensaje);
        } catch (IOException e) {
            Logger.getLogger(idConversacion);
        }
        acl.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
        acl.setConversationId(idConversacion);  // codigo entre los agentes para que se comuniquen
        agenteEmisor.send(acl);
    }
}
