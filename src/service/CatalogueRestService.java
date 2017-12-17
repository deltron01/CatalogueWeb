package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import metier.ICatalogueLocal;
import metier.Produit;

@Stateless
@Path("/catalogue")        // @Path indique que c'est un webservice type restfull
public class CatalogueRestService {
	@EJB
	private ICatalogueLocal metier;
	
	@GET
	@Path("produitsParMC/{motCle}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produit> consulterProduits(@PathParam(value="motCle") String motcle){
    	return metier.getProduitsParMC(motcle);
    }
	@GET
	@Path("/produits")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produit> getAllProduits(){
    	return metier.getAllProduits();
    }
	@GET
	@Path("save/{nom}/{prix}")
	public void saveProduit(@PathParam(value="nom") String nom, @PathParam(value="prix") double prix){
		metier.addProduit(new Produit(nom, prix));
	}
}
