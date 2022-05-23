package web;
import métier.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import dao.IJeuDao;
import dao.JeuImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name = "cs", urlPatterns = {"*.servlet"})
public class controleurPrincipal extends HttpServlet {
	IJeuDao dao;
	Fonctions F = new Fonctions();
	Plateau PlateauPrincipale;
	ArrayList<Carte> carteJoueur;
	ArrayList<Carte> Allcartes;
	Jeu jeuA;
	Match matchA = new Match();
	int i=0 , j=0;
	public void init() throws ServletException {
		dao = new JeuImpl();
		F = new Fonctions();
		Scanner scanner = new Scanner(System.in);
		PlateauPrincipale = new Plateau();
//Les lieux de Plateaux 
	// les positions de chaque lieu 
		// Hall
		ArrayList<Position> PsL1 = new ArrayList<Position>();
		for(int k=19;k<25;k++) {
			for(int j=11;j<16;j++) {
				if(PlateauPrincipale.getTableau()[k][j]==1) {
					PsL1.add(new Position(k, j));
				}
			}
		}
		
		// Bureau
		ArrayList<Position> PsL2 = new ArrayList<Position>();
		for(int k=21;k<26;k++) {
			for(int j=19;j<26;j++) {
				if(PlateauPrincipale.getTableau()[k][j]==1) {
					PsL2.add(new Position(k, j));
				}
			}
		}
		
		// Bibliothéque
		ArrayList<Position> PsL3 = new ArrayList<Position>();
		for(int k=14;k<18;k++) {
			for(int j=19;j<26;j++) {
				if(PlateauPrincipale.getTableau()[k][j]==1) {
					PsL3.add(new Position(k, j));
				}
			}
		}
		
		// Salle de jeux
		ArrayList<Position> PsL4 = new ArrayList<Position>();
		for(int k=9;k<12;k++) {
			for(int j=20;j<25;j++) {
				if(PlateauPrincipale.getTableau()[k][j]==1) {
					PsL4.add(new Position(k, j));
				}
			}
		}
		
		// Terrasse
				ArrayList<Position> PsL5 = new ArrayList<Position>();
				for(int k=1;k<6;k++) {
					for(int j=21;j<25;j++) {
						if(PlateauPrincipale.getTableau()[k][j]==1) {
							PsL5.add(new Position(k, j));
						}
					}
				}
		// Salle de danse
		ArrayList<Position> PsL6 = new ArrayList<Position>();
		for(int k=2;k<7;k++) {
			for(int j=10;j<=16;j++) {
				if(PlateauPrincipale.getTableau()[k][j]==1) {
					PsL6.add(new Position(k, j));
				}
			}
		}
		
		// cuisine
		ArrayList<Position> PsL7 = new ArrayList<Position>();
		for(int k=0;k<7;k++) {
			for(int j=0;j<7;j++) {
				if(PlateauPrincipale.getTableau()[k][j]==1) {
					PsL7.add(new Position(k, j));
				}
			}
		}
		
		// Salle a manger
		ArrayList<Position> PsL8 = new ArrayList<Position>();
		for(int k=11;k<16;k++) {
			for(int j=2;j<8;j++) {
				if(PlateauPrincipale.getTableau()[k][j]==1) {
					PsL8.add(new Position(k, j));
				}
			}
		}
		
		// Salon
		ArrayList<Position> PsL9 = new ArrayList<Position>();
		for(int k=20;k<25;k++) {
			for(int j=2;j<7;j++) {
				if(PlateauPrincipale.getTableau()[k][j]==1) {
					PsL9.add(new Position(k, j));
				}
			}
		}
// les positions des portes 
			// Hall 
			ArrayList<Position> PsPoL1 = new ArrayList<Position>();
			PsPoL1.add(new Position(19, 12));
			PsPoL1.add(new Position(19, 13));
			PsPoL1.add(new Position(19, 14));
			PsPoL1.add(new Position(21, 16));
			// Bureau 
			ArrayList<Position> PsPoL2 = new ArrayList<Position>();
			PsPoL2.add(new Position(21, 22));
			// Bibliothéque 
			ArrayList<Position> PsPoL3 = new ArrayList<Position>();
			PsPoL3.add(new Position(14, 22));
			PsPoL3.add(new Position(16, 18));		
			// Salle de jeux
			ArrayList<Position> PsPoL4 = new ArrayList<Position>();
			PsPoL4.add(new Position(10, 19));
			PsPoL4.add(new Position(12, 24));
			// Terrasse
			ArrayList<Position> PsPoL5 = new ArrayList<Position>();
			PsPoL5.add(new Position(5, 21));
			// Salle de danse
			ArrayList<Position> PsPoL6 = new ArrayList<Position>();
			PsPoL6.add(new Position(9, 6));
			PsPoL6.add(new Position(10, 7));
			PsPoL6.add(new Position(10, 13));
			PsPoL6.add(new Position(9, 14));		
			// Cuisine
			ArrayList<Position> PsPoL7 = new ArrayList<Position>();
			PsPoL7.add(new Position(7, 4));			
			// Salle a manger
			ArrayList<Position> PsPoL8 = new ArrayList<Position>();
			PsPoL8.add(new Position(13, 8));
			PsPoL8.add(new Position(16, 7));			
			// Salon
			ArrayList<Position> PsPoL9 = new ArrayList<Position>();
			PsPoL9.add(new Position(21, 7));
// les lieu 
		Lieu L1 = new Lieu("Hall", 4, PsPoL1, PsL1);
		Lieu L2 = new Lieu("Le bureau", 1, PsPoL2, PsL2);
		Lieu L3 = new Lieu("Bibliothéque", 2, PsPoL3, PsL3);
		Lieu L4 = new Lieu("Salle de jeux", 2, PsPoL4, PsL4);
		Lieu L5 = new Lieu("Terrasse", 1, PsPoL5, PsL5);
		Lieu L6 = new Lieu("Salle de danse", 4, PsPoL6, PsL6);
		Lieu L7 = new Lieu("Cuisine", 1, PsPoL7, PsL7);
		Lieu L8 = new Lieu("Salle à manger", 2, PsPoL8, PsL8);
		Lieu L9 = new Lieu("Le salon", 1, PsPoL9, PsL9);
		
		PlateauPrincipale.getLieuxPlateau().add(L1);
		PlateauPrincipale.getLieuxPlateau().add(L2);
		PlateauPrincipale.getLieuxPlateau().add(L3);
		PlateauPrincipale.getLieuxPlateau().add(L4);
		PlateauPrincipale.getLieuxPlateau().add(L5);
		PlateauPrincipale.getLieuxPlateau().add(L6);
		PlateauPrincipale.getLieuxPlateau().add(L7);
		PlateauPrincipale.getLieuxPlateau().add(L8);
		PlateauPrincipale.getLieuxPlateau().add(L9);
		
// Cartes lieux
		Carte CL1 = new CarteLieu(1, "Hall");
		Carte CL2 = new CarteLieu(2, "Le bureau");
		Carte CL3 = new CarteLieu(3, "Bibliothéque");
		Carte CL4 = new CarteLieu(4, "Salle de jeux");
		Carte CL5 = new CarteLieu(5, "Terrasse");
		Carte CL6 = new CarteLieu(6, "Salle de danse");
		Carte CL7 = new CarteLieu(7, "Cuisine");
		Carte CL8 = new CarteLieu(8, "Salle à manger");
		Carte CL9 = new CarteLieu(9, "Le salon");
// Cartes Armes
		Carte A1 = new CarteArme(10, "Dague");
		Carte A2 = new CarteArme(11, "Tuyau de plomb");
		Carte A3 = new CarteArme(12, "Clé");
		Carte A4 = new CarteArme(13, "Chandelier");
		Carte A5 = new CarteArme(14, "Revolver");
		Carte A6 = new CarteArme(15, "Corde");
// Cartes Suspects
		Carte S1 = new CarteSuspect(16, "Rouge");
		Carte S2 = new CarteSuspect(17, "Vert");
		Carte S3 = new CarteSuspect(18, "Blanc");
		Carte S4 = new CarteSuspect(19, "Violet");
		Carte S5 = new CarteSuspect(20, "Bleu");
		Carte S6 = new CarteSuspect(21, "jaune");
		carteJoueur = new ArrayList<Carte>();
		Allcartes = new ArrayList<Carte>();
		Allcartes.add(CL1);
		Allcartes.add(CL2);
		Allcartes.add(CL3);
		Allcartes.add(CL4);
		Allcartes.add(CL5);
		Allcartes.add(CL6);
		Allcartes.add(CL7);
		Allcartes.add(CL8);
		Allcartes.add(CL9);
		Allcartes.add(A1);
		Allcartes.add(A2);
		Allcartes.add(A3);
		Allcartes.add(A4);
		Allcartes.add(A5);
		Allcartes.add(A6);
		Allcartes.add(S1);
		Allcartes.add(S2);
		Allcartes.add(S3);
		Allcartes.add(S4);
		Allcartes.add(S5);
		Allcartes.add(S6);
//Instantiation d'un jeu :
		jeuA = new Jeu();
		jeuA.setCartesJeu(Allcartes);
//Instantiation d'un Match :
		matchA = new Match();
		matchA.setJeu(jeuA);
		matchA.setEtatMatch("N");	
		matchA.setDateMatch(new Date(2021,12,13));
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath(); 
		if (path.equals("/joueursnombre.servlet")) {
			int  nbr = Integer.parseInt(request.getParameter("nbr"));
			System.out.println("number is "+nbr);
			jeuA.distribuerCartes(nbr);
			i=F.gererTour(jeuA, i);
			j=F.gererTourPlus(jeuA, F.TourJeu(jeuA));
			j=F.gererTourRepondre(jeuA, F.TourJeu(jeuA), j);
			System.out.println(jeuA.getCartesEnveloppe());
			request.setAttribute("nbr",nbr);
			request.setAttribute("joueurIndex",F.TourJeu(jeuA));
			request.setAttribute("indexesC",F.idCarteCochees(jeuA.getJoueurs().get(F.TourJeu(jeuA))));
			request.setAttribute("indexes",F.idCarteJoueurs(jeuA.getJoueurs().get(0)));
			request.getRequestDispatcher("board.jsp").forward(request, response);
			
			
	 }else if (path.equals("/deplacement.servlet")) {
			String deplacement = request.getParameter("dep");
			if(deplacement==null) {
				deplacement="AA";
			}
			//F.AffichageTabPlateau(PlateauPrincipale);
			
			String A = deplacement.charAt(0)+"";
			Position op = jeuA.getJoueurs().get(F.TourJeu(jeuA)).getPositionActuelPion();
			
			
			int a=F.TourJeu(jeuA);
			F.daplacer(jeuA, PlateauPrincipale,A);
			//F.AffichageTabPlateau(PlateauPrincipale);
			
			JSONObject json = new JSONObject();
			try {
				json.put("jiav",a);
				json.put("joueurIndex",F.TourJeu(jeuA));
				json.put("joueurIndexrep",F.TourRepondreJeu(jeuA));
				json.put("deplacement", deplacement);
				json.put("OL", op.getLigne());
				json.put("OC", op.getColonne());
				json.put("NL", jeuA.getJoueurs().get(F.TourJeu(jeuA)).getPositionActuelPion().getLigne());
				json.put("NC", jeuA.getJoueurs().get(F.TourJeu(jeuA)).getPositionActuelPion().getColonne());
				json.put("nbrdep",jeuA.getJoueurs().get(F.TourJeu(jeuA)).getNbrDeDeplacement());
				//json.put("CartesIds", F.idCarteJoueurs(jeuA.getJoueurs().get(F.TourJeu(jeuA))));
				//json.put("NotesCocheesids", F.idCarteCochees(jeuA.getJoueurs().get(F.TourJeu(jeuA))));
				
				
			} catch (JSONException e){
				e.printStackTrace();
			}
			
			String greetings =json.toString();
			response.setContentType("text/plain");
			response.getWriter().write(greetings);
			
			
			if(jeuA.getJoueurs().get(F.TourJeu(jeuA)).getNbrDeDeplacement()==0) {
				//jeuA.getJoueurs().get(F.TourJeu(jeuA)).setNbrDeDeplacement(1);
				//op = jeuA.getJoueurs().get(F.TourJeu(jeuA)).getPositionActuelPion();
				//F.daplacer(jeuA, PlateauPrincipale,A);
				  i=F.gererTour(jeuA, i);
				  j=F.gererTourPlus(jeuA, F.TourJeu(jeuA));
				  j=F.gererTourRepondre(jeuA, F.TourJeu(jeuA), j);
				  
				}
			

		}else if (path.equals("/lancerLeDe.servlet")) {
			int a = Integer.parseInt(request.getParameter("ind"));
			System.out.println(a+"  "+F.TourJeu(jeuA));
			int t = F.TourJeu(jeuA);
			jeuA.getJoueurs().get(t).setNbrDeDeplacement(a);
			JSONObject json = new JSONObject();
			try {
				json.put("NotesCocheesids", F.idCarteCochees(jeuA.getJoueurs().get(t)));
				json.put("CartesIds", F.idCarteJoueurs(jeuA.getJoueurs().get(F.TourJeu(jeuA))));
				json.put("tour",F.TourJeu(jeuA));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String greetings =json.toString();
			response.setContentType("text/plain");
			response.getWriter().write(greetings);
		}
		
		//----------------------------------
		
		else if (path.equals("/faireHypothese.servlet")) {
			JSONObject json = new JSONObject();
			Position pa = new Position();
			pa.setColonne(jeuA.getJoueurs().get(F.TourJeu(jeuA)).getPositionActuelPion().getColonne());
			pa.setLigne(jeuA.getJoueurs().get(F.TourJeu(jeuA)).getPositionActuelPion().getLigne());

		    if(F.lieuJoueur(PlateauPrincipale,pa)==null){
		    	
		    	System.out.println(F.lieuJoueur(PlateauPrincipale,pa));
		    	try {
					json.put("CarteLieuId","null");
				} catch (JSONException e) {
					e.printStackTrace();
				}
		    	
		    	
		    	
		    }else {

		    	System.out.println(F.lieuJoueur(PlateauPrincipale,pa));
				try {
					   json.put("CarteLieuId",F.carteLieu(jeuA,F.lieuJoueur(PlateauPrincipale,pa)).getIdCarte());
					   json.put("idsCartesArmHyp", F.idsDesCartesArmes(jeuA, jeuA.getJoueurs().get(F.TourJeu(jeuA))));
					   json.put("idsCartesSusHyp", F.idsDesCartesSuspect(jeuA, jeuA.getJoueurs().get(F.TourJeu(jeuA))));
				    } catch (JSONException e){
					e.printStackTrace();
				}
		    
		    }
			String greetings =json.toString();
			response.setContentType("text/plain");
			response.getWriter().write(greetings);
			// test test 
			jeuA.getJoueurs().get(F.TourJeu(jeuA)).setNbrDeDeplacement(0);
		
		
		}
		
		//------------------------------
		else if(path.equals("/sauvgarder.servlet")) {
			String res = request.getParameter("checked");
			System.out.println(res);
			ArrayList<Integer> list = new ArrayList<>();   
			try {
				JSONArray jsonArray =  new JSONArray(res);
				if (jsonArray != null) { 
				   int len = jsonArray.length();
				   for (int i=0;i<len;i++){ 
				    list.add((Integer) jsonArray.get(i));
				   } 
				   System.out.println(list);
				   F.sauvgarder(jeuA, jeuA.getJoueurs().get(F.TourJeu(jeuA)), list);
				} 
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  

		}
		else if (path.equals("/repondre.servlet")) {
			
	    	int id1 =Integer.parseInt(request.getParameter("id1"));
	    	int id2 =Integer.parseInt(request.getParameter("id2"));
	    	int id3 =Integer.parseInt(request.getParameter("id3"));
			ArrayList<Integer> list = new ArrayList<>();   
			list.add(id1);
			list.add(id2);
			list.add(id3);
			ArrayList<Carte> hyp = new ArrayList<>(F.cartesIds(jeuA, list));
			Carte c = new Carte();
			jeuA.getJoueurs().get(F.TourJeu(jeuA)).setHypotheseJoueur(hyp);
			int sc = 0;
			String s="";
			int tr = F.TourRepondreJeu(jeuA);
			int t= jeuA.getJoueurs().size()-1;
		    do {
		    	c = jeuA.getJoueurs().get(tr).repondre(jeuA, hyp,0);
		    	tr=F.gererTourRepondre(jeuA, F.TourJeu(jeuA), tr);
		        t--;
		       }while(c==null && t>0);
			
		   if(c!=null) {
			   sc=c.getIdCarte();
	    	   s="Le Joueur "+ (F.TourRepondreJeu(jeuA)+1)+", vous montrer la Carte : "+c.getNomCarte();
		    }
		    else{
		        s ="pas de reponse , peut etre, vous trouver la solution de le crime !!";
		    }
		   	
		   	JSONObject json = new JSONObject();
		   	try {
				json.put("s", s);
				json.put("id", sc);

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String greetings =json.toString(); 
		    response.setContentType("text/plain");
			response.getWriter().write(greetings);
	    	
	    }
		else if(path.equals("/resoudre.servlet")) {
			//if(F.lieuJoueur(PlateauPrincipale, jeuA.getJoueurs().get(F.TourJeu(jeuA)).getPositionActuelPion())!=null) {
			JSONObject json = new JSONObject();
			ArrayList<Integer> res = new ArrayList<Integer>();
			for(Carte c :jeuA.getCartesJeu()) 
			{
				if(!(jeuA.getJoueurs().get(F.TourJeu(jeuA)).getCartesJoueur().contains(c))) {
					res.add(c.getIdCarte());
				}
			}
			System.out.println(res);
			ArrayList<Integer> lieux = new ArrayList();
			ArrayList<Integer> Armes = new ArrayList<Integer>();
			ArrayList<Integer> Suspects = new ArrayList<Integer>();
			for(int t=0;t<res.size();t++) {
				if(res.get(t)<=9) {
					lieux.add(res.get(t));
				}
				else if(res.get(t)<=15 && res.get(t)>=10){
					Armes.add(res.get(t));
				}
				else {
					Suspects.add(res.get(t));
				}
			}
			
			try {
				json.put("CartesLieuxPossibles", lieux);
				json.put("CartesArmesPossibles", Armes);
				json.put("CartesSuspectPossibles", Suspects);
			} catch (JSONException e) {
				// TODO Auto-generated catch block<
				e.printStackTrace();
			}
			String greetings =json.toString(); 
		    response.setContentType("text/plain");
			response.getWriter().write(greetings);			
			//}
		}
		else if(path.equals("/compare.servlet")) {
			
			int idRC1 =Integer.parseInt(request.getParameter("idR1"));
	    	int idRC2 =Integer.parseInt(request.getParameter("idR2"));
	    	int idRC3 =Integer.parseInt(request.getParameter("idR3"));
	    	
			ArrayList<Integer> list = new ArrayList<>();   
			list.add(idRC1);
			list.add(idRC2);
			list.add(idRC3);
			
			ArrayList<Carte> CartesResoudre = new ArrayList<>(F.cartesIds(jeuA, list));
			String res = ""+jeuA.comparer(CartesResoudre);
			String etat = jeuA.getJoueurs().get(F.TourJeu(jeuA)).getEtatJeu();
			JSONObject json = new JSONObject();
			try {
				json.put("res", res);
				json.put("etat", etat);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String greetings =json.toString(); 
		    response.setContentType("text/plain");
			response.getWriter().write(greetings);
			
		}
		
		else if(path.equals("/seConnecter.servlet")) {
        	
        	String userName =request.getParameter("username");
	    	String passWord =request.getParameter("password");
	        System.out.println("this is the UserName : "+userName);
            Utilisateur user =dao.chercherUtilisateur(userName);
            System.out.println("this is the list return4ed by dao: "+user.toString());
            if(user.getPassWord().equals(passWord)) {
            	request.getRequestDispatcher("numberOfPlayersChoice.jsp").forward(request, response);
            }
            else {
            	response.sendRedirect("Authentification.jsp");
            }
		
		}
		
		else if(path.equals("/passageSecret.servlet")){
			if(F.isPassagesSecret(jeuA)==true) {
			int ol=jeuA.getJoueurs().get(F.TourJeu(jeuA)).getPositionActuelPion().getLigne();
			int oc=jeuA.getJoueurs().get(F.TourJeu(jeuA)).getPositionActuelPion().getColonne();
				F.passagesSecret(jeuA);
				jeuA.getJoueurs().get(F.TourJeu(jeuA)).setNbrDeDeplacement(0);
				JSONObject json = new JSONObject();
				try {
					json.put("newligne", jeuA.getJoueurs().get(F.TourJeu(jeuA)).getPositionActuelPion().getLigne());
					json.put("newcolonne", jeuA.getJoueurs().get(F.TourJeu(jeuA)).getPositionActuelPion().getColonne());
					json.put("olligne", ol);
					json.put("occolonne", oc);
					json.put("tour",F.TourJeu(jeuA));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String greetings =json.toString(); 
			    response.setContentType("text/plain");
				response.getWriter().write(greetings);
			}
		}
		else {
			System.out.println("XXXXXX");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}