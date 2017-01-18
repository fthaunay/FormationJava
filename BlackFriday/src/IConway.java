
//package fr.lteconsulting;

/**
 * Votre classe du Jeu De La Vie doit impl�menter cette interface
 * afin que la classe {@link BoardDisplay} puisse faire l'affichage
 */
public interface IConway
{
	/**
	 * Largeur du damier
	 */
	int getWidth();

	/**
	 * Hauteur du damier
	 */
	int getHeight();

	/**
	 * Renvoie {@code true} si la cellule � la coordonn�e {@code (x, y)} est vivante,
	 * {@code false} sinon.
	 */
	boolean getCell( int x, int y );

	/**
	 * Fait �voluer le damier selon les r�gles du jeu de Conway
	 */
	void evolve();
}