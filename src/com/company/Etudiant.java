package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Etudiant {

    // objet pour obtenir des donnees de l'utilisateur
    private Scanner scan = new Scanner(System.in);

// initialisateur du nom : stocke le nom quand un Etudiant est instancie

    public String nom;
    {
        System.out.println("Entrez le nom de l'etudiant");
        nom = scan.nextLine();
    }

    // initialisateur de la moyenne : stocke la moyenne quand un Etudiant est instancie
    public double moyenne;
    {
        System.out.println("Entrez la moyenne de l'etudiant");
        moyenne = scan.nextDouble();
        scan.nextLine();

    }

    // initialisateur du genre : stocke le genre quand un Etudiant est instancie
    public String genre;
    {
        System.out.println("Entrez le sex : Masculin ou Feminin ou Autre?");
        genre = scan.nextLine();


    }

    Date date = null;
    boolean goodDate = false;

    // initialisateur de la date de naissance : stocke la date quand un Etudiant est instancie
    public Date dateNaissance;
    {

        while(!goodDate)
        {
            System.out.println("Date de naissance : (format : dd/MM/YY) : ");
            String dateIntString = scan.nextLine();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
            try
            {
                date = formatter.parse(dateIntString);
                goodDate = true;
            }catch(Exception e){

            }
            dateNaissance = date;

        }

    }

    // initialisateur du matricule : stocke le matricule quand un Etudiant est instancie
    private String matricule;
    {
        System.out.println("Entrez le matricule de l'etudiant");
        matricule = scan.nextLine();
        System.out.println("\n");

    }

    // Constructeur de la classe etudiant
    public Etudiant( )
    {


    }

    // Methode Afficher() : affiche les informations sur les etudiants
    public void afficher()
    {
        System.out.println("Nom : "+nom);
        System.out.println("Matricule : "+matricule);
        System.out.println("Genre : "+genre);
        System.out.println("Date de Naissance : "+dateNaissance);
        System.out.println("Age : "+calculerAge());
        System.out.println("Moyenne : "+(bonifier(moyenne)+moyenne));
    }

    // Methode calculerAge() : Calcule l'age de l'etudiant
    public int calculerAge()
    {
        return new Date().getYear() - dateNaissance.getYear();
    }

    // Methode bonifier() : Calcule le bonus de l'etudiant basee sur ca note
    public double bonifier(double moy)
    {
        if(moy>14&&moy<20)
        {
            moy=(moy/20)+0.5;
            System.out.println("Bien travailler, bonus donne");
        }
        else

        if (moy==20)
        {
            System.out.println("Bien travailler, mais Max deja obtenue");
            moy=0;
        }
        else
        {
            System.out.println("Non eligible pour un bonus");
            moy=0;
        }

        return moy;
    }



}
