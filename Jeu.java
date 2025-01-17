import sun.awt.X11.XSystemTrayPeer;

import java.util.Scanner;
public class Jeu {
    //il y aura 4 modes de jeu le premier sera le mode 1 joueur contre l'ordinateur avec toutes les pieces, le deuxieme
    // avec seulement des dominos, le troisieme avec que les triominos et le quatrieme avec que les tetrominos
    private int game;
    public Jeu() {
        game = 1;
    }
    public void Choose_Game(){
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Choisissez le mode de jeu : ");
            System.out.println("1 : 1 joueur contre l'ordinateur avec toutes les pieces et toujours les mêmes pieces (Jeu de base)");
            System.out.println("2 : 1 joueur contre l'ordinateur avec toutes les pieces");
            System.out.println("3 : 1 joueur contre l'ordinateur avec seulement des dominos");
            System.out.println("4 : 1 joueur contre l'ordinateur avec seulement des triominos");
            System.out.println("5 : 1 joueur contre l'ordinateur avec seulement des tetrominos");
            this.game = sc.nextInt();
        } while (this.game < 1 || this.game > 5);
        switch (this.game) {
            case 1:
                Game_Basic();
                break;
            case 2:
                //Game_All_Pieces();
                break;
            case 3:
                //Game_Dominos();
                break;
            case 4:
                //Game_Triominos();
                break;
            case 5:
                //Game_Tetrominos();
                break;
        }

    }

    public int getGame() {
        return this.game;
    }
    public void setGame(int game) {
        this.game = game;
    }

    public void Game_Basic() {
        Grille grille = new Grille();
        Joueur joueur = new Joueur();
        Scanner sc = new Scanner(System.in);
        Joueur ordinateur = new Joueur();
        Piece[] dominos = new Piece[1];
        Piece[] triominos = new Piece[2];
        Piece[] tetrominos = new Piece[7];
        //dominos
        dominos[0] = new Piece(2, "dominos", "O", 0, 0);
        dominos[0].dominos();
        dominos[0].setValeur("0");
        //triominos
        triominos[0] = new Piece(3, "triominos", "O", 0, 0);
        triominos[0].triominos_barre();
        triominos[0].setValeur("0");
        triominos[1] = new Piece(3, "triominos", "O", 0, 0);
        triominos[1].triominos_L();
        triominos[1].setValeur("0");
        //tetrominos
        tetrominos[0] = new Piece(4, "tetrominos", "O", 0, 0);
        tetrominos[0].Tetrominos_T();
        tetrominos[0].setValeur("0");
        tetrominos[1] = new Piece(4, "tetrominos", "O", 0, 0);
        tetrominos[1].Tetrominos_S();
        tetrominos[1].setValeur("0");
        tetrominos[2] = new Piece(4, "tetrominos", "O", 0, 0);
        tetrominos[2].Tetrominos_L();
        tetrominos[2].setValeur("0");
        tetrominos[3] = new Piece(4, "tetrominos", "O", 0, 0);
        tetrominos[3].Tetrominos_Carre();
        tetrominos[3].setValeur("0");
        tetrominos[4] = new Piece(4, "tetrominos", "O", 0, 0);
        tetrominos[4].Tetrominos_L_inverse();
        tetrominos[4].setValeur("0");
        tetrominos[5] = new Piece(4, "tetrominos", "O", 0, 0);
        tetrominos[5].Tetrominos_S_inverse();
        tetrominos[5].setValeur("0");
        tetrominos[6] = new Piece(4, "tetrominos", "O", 0, 0);
        tetrominos[6].Tetrominos_Barre();
        tetrominos[6].setValeur("0");
        //on va creer un tableau de pieces qui contiendra toutes les pieces
        System.out.println(dominos[0].getValeur());
        Piece[] pieces = new Piece[10];
        pieces[0] = dominos[0];
        pieces[1] = triominos[0];
        pieces[2] = triominos[1];
        pieces[3] = tetrominos[0];
        pieces[4] = tetrominos[1];
        pieces[5] = tetrominos[2];
        pieces[6] = tetrominos[3];
        pieces[7] = tetrominos[4];
        pieces[8] = tetrominos[5];
        pieces[9] = tetrominos[6];
        //on va creer un tableau de pieces qui contiendra toutes les pieces
        Piece[] pieces_ordinateur = new Piece[9];
        pieces_ordinateur[0] = dominos[0];
        pieces_ordinateur[1] = triominos[0];
        pieces_ordinateur[2] = triominos[1];
        pieces_ordinateur[3] = tetrominos[0];
        pieces_ordinateur[4] = tetrominos[1];
        pieces_ordinateur[5] = tetrominos[2];
        pieces_ordinateur[6] = tetrominos[3];
        pieces_ordinateur[7] = tetrominos[4];
        pieces_ordinateur[8] = tetrominos[5];
        while(Win_Joueur(joueur,grille)== false){
            System.out.println("Veuillez saisir la piece que vous voulez placer : ");
            System.out.println("1 : Domino");
            System.out.println("2 : Triomino barre");
            System.out.println("3 : Triomino L");
            System.out.println("4 : Tetromino T");
            System.out.println("5 : Tetromino S");
            System.out.println("6 : Tetromino L");
            System.out.println("7 : Tetromino Carre");
            System.out.println("8 : Tetromino L inverse");
            System.out.println("9 : Tetromino S inverse");
            System.out.println("10 : tetromino barre");
            System.out.println("11 : quittez le jeu");
            int choix = sc.nextInt();
            while(choix < 1 || choix > 11){
                System.out.println("Veuillez saisir un nombre entre 1 et 11 : ");
                choix = sc.nextInt();
            }
            if (choix == 11){
                System.out.println("Vous avez quittez le jeu");
                System.exit(0);
            }
            System.out.println("Veuillez saisir la position en x de la piece que vous voulez placer : ");
            int pos_x = sc.nextInt();
            System.out.println("Veuillez saisir la position en y de la piece que vous voulez placer : ");
            int pos_y = sc.nextInt();
            while(pos_x < 0 || pos_x > 12 || pos_y < 0 || pos_y > 10){
                System.out.println("Veuillez saisir une position entre 0 et 12 : ");
                System.out.println("Veuillez saisir la position en x de la piece que vous voulez placer : ");
                pos_x = sc.nextInt();
                System.out.println("Veuillez saisir la position en y de la piece que vous voulez placer : ");
                pos_y = sc.nextInt();
            }
            pieces[choix-1].setPos_x(pos_x);
            pieces[choix-1].setPos_y(pos_y);
            grille.placerPiece(pieces[choix-1]);
            grille.afficher();
        }

    }

    public void Game_Domino() {
        Grille grille = new Grille();
        Joueur joueur = new Joueur();
        Joueur ordinateur = new Joueur();
        Piece[] dominos = new Piece[1];
        //dominos
        dominos[0] = new Piece(2, "dominos", "#", 0, 0);
        dominos[0].dominos();
        //on va creer un tableau de pieces qui contiendra toutes les pieces
        Piece[] pieces = new Piece[1];
        pieces[0] = dominos[0];
        //on va creer un tableau de pieces qui contiendra toutes les pieces
        Piece[] pieces_ordinateur = new Piece[1];
        pieces_ordinateur[0] = dominos[0];
    }
    public boolean Win_Joueur(Joueur joueur,Grille grille) {
        //pour detecter si il y a un gangant il faut que le joueur adverse ne puisse plus placer aucune pieces
        //on va donc regarder si les deux joueurs ne peuvent plus placer de pieces

        if (grille.Dominos_possible() == false) {
            return true;
        }
        else {
            if (grille.Triominos_barre_possible() == false && grille.Triominos_L_possible() == false) {
                return true;
            }
            else {
                if (grille.Tetrominos_Carre_possible() == false && grille.Tetrominos_L_possible() == false
                        && grille.Tetrominos_S_possible() == false && grille.Tetrominos_S_inverse_possible() == false
                        && grille.Tetrominos_T_possible() == false && grille.Tetrominos_L_inverse_possible() == false) {
                    return true;
                }
                else {
                    return false;
                }
            }

        }
    }

}
