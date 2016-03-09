package com.cdiez.triviapam.Model;

/**
 * Created by Carlos Diez
 * on 1/25/16.
 */
public class Trivia {

    private Question[] mQuestions;

    public Trivia() {
        mQuestions = new Question[8];

        Choice[][] choices = new Choice[][]{
                {new Choice("101 Dálmatas", false), new Choice("La Cenicienta", false), new Choice("Fantasía", false), new Choice("Blanca Nieves y los siete Enanos", true)},
                {new Choice("La Bella Durmiente", true), new Choice("La Espada en la Piedra", false), new Choice("Robin Hood", false), new Choice("Alicia en el País de las Maravillas", false)},
                {new Choice("El Pequeño Juan", false), new Choice("El Sheriff de Nottingham", false), new Choice("Toby, la tortuga", false), new Choice("El fraile Tuck", true)},
                {new Choice("Dejar desordenado su dormitorio", false), new Choice("Reunirse con Úrsula", false), new Choice("Salir a la superficie", true), new Choice("Jugar con tiburones", false)},
                {new Choice("Bambi", false), new Choice("La Cenicienta", true), new Choice("Peter Pan", false), new Choice("El Caldero Mágico", false)},
                {new Choice("Rojo", false), new Choice("Azul", false), new Choice("Amarillo", true), new Choice("Verde", false)},
                {new Choice("Galera y visera", false), new Choice("Sombrero de copa y sombrero de paja", false), new Choice("Gorro de cazador y bombín", true), new Choice("Casco y gorro de aviador", false)},
                {new Choice("Si", true), new Choice("No", false), new Choice("Tal vez", false), new Choice("No se", false)}
        };

        mQuestions[0] = new Question("¿Qué película animada de Disney fue proyectada más veces en el cine?",
                choices[0]);

        mQuestions[1] = new Question("¿Qué largometraje incluye la canción Copas?",
                choices[1]);

        mQuestions[2] = new Question("¿Qué personaje de Robin Hood fue primero pensado como un cerdo?",
                choices[2]);

        mQuestions[3] = new Question("El rey Tritón le dice a Ariel: “Mientras vivas bajo mi océano, obedecerás mis reglas”. ¿Qué le dice que NO haga?",
                choices[3]);

        mQuestions[4] = new Question("¿Qué largometraje está basado en la historia alemana “Aschenputtel”?",
                choices[4]);

        mQuestions[5] = new Question("¿De qué color era el auto nuevo de Mike en Monsters, Inc.?",
                choices[5]);

        mQuestions[6] = new Question("¿Qué tipo de sombreros usaban Topo y el Sr. Rata en La leyenda de Sleepy Hollow y el Señor Sapo?",
                choices[6]);

        mQuestions[7] = new Question("¿Quieres ser mi novia?",
                choices[7]);
    }

    public Question getQuestion(int questionNumber) {
        return mQuestions[questionNumber];
    }
}