package com.company;
import java.util.Scanner;

public class GestionEtudiant {

    public static void run()
    {
        // Declaration et recolte des variable
        int n, choice;
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrez le nombre d'etudiants");
        n = sc.nextInt();

        // Declaration du tableau contenant des objets Etudiant
        Etudiant[] tabEtudiants = new Etudiant[n];

        // initialisation et remplissage du tableau (Chaque Etudiants va recolter ses attributs en utilisant les initialisateurs)
        for(int i=0; i<n; i++)
        {
            tabEtudiants[i] = new Etudiant();
        }

        // Menu
        do
        {

            System.out.println("Que voulez vous faire?");
            System.out.println("1. Afficher les etudiants par ordre de merite");
            System.out.println("2. Afficher les informations sur le premier etudiant");
            System.out.println("3. Afficher les informations du dernier etudiant");
            System.out.println("4. Reinitialiser la liste de la classe");
            System.out.println("5. Sortir du programme");
            choice = sc.nextInt();

            // Triage du tableau
            for (int i = 1; i < n; i++)
            {
                double index = tabEtudiants[i].moyenne;
                Etudiant indexEtudiant = tabEtudiants[i];
                int j = i-1;

                while(j >= 0 && tabEtudiants[j].moyenne < index)
                {
                    tabEtudiants[j+1] = tabEtudiants[j];
                    j--;
                }
                tabEtudiants[j+1] = indexEtudiant;
            }

            switch(choice)
            {
                case 1:
                    System.out.println("Etudiants par ordre de merite");
                    for (int i = 0; i < n; i++)
                    {
                        tabEtudiants[i].afficher();
                        System.out.print("\n");
                    }
                    break;
                case 2 :
                    System.out.println("Premier etudiant");
                    tabEtudiants[0].afficher();
                    break;
                case 3 :
                    System.out.println("Dernier etudiant");
                    tabEtudiants[n-1].afficher();
                    break;
                case 4 :
                    tabEtudiants = new Etudiant[n];
                    System.out.println("Entrez le nombre d'etudiants");
                    n = sc.nextInt();
                    for(int i=0; i<n; i++)
                    {
                        tabEtudiants[i] = new Etudiant();
                    }
                    break;
                case 5 :
                    System.out.println("Au revoir!");
                    break;

            }

        }while(choice!=5);




    // fin
        
    }
}
