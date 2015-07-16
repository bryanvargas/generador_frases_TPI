package repositorio.persistente;
import java.util.ArrayList;
import com.acceso.datos.Adjetivo;
import com.acceso.datos.Adverbio;
import com.acceso.datos.Conjuncion;
import com.acceso.datos.Determinante;
import com.acceso.datos.Preposicion;
import com.acceso.datos.Pronombre;
import com.acceso.datos.Sustantivo;
import com.acceso.datos.Verbo;



public class Repositorio  {
    private ArrayList<Adjetivo> adjetivos;
    private ArrayList<Adjetivo> adjetivosFuertes;    
    private ArrayList<Sustantivo> sustantivosAmor;
    private ArrayList<Sustantivo> sustantivosOdio;
    private ArrayList<Sustantivo> sustantivosTristeza;
    private ArrayList<Sustantivo> sustantivosAlegria;
    private ArrayList<Sustantivo> sustantivosDeporte;
    private ArrayList<Verbo> verbos;
    private ArrayList<Adverbio> adverbios;
    private ArrayList<Preposicion> preposiciones;
    private ArrayList<Pronombre> pronombres;
    private ArrayList<Determinante> determinantes;
    private ArrayList<Conjuncion> conjunciones;
    private boolean singular;
    private boolean masculino;
    
    public Repositorio() {
    	adjetivos = new ArrayList<Adjetivo>();
    	adjetivosFuertes = new ArrayList<Adjetivo>();
    	adjetivosFuertes = new ArrayList<Adjetivo>();
    	sustantivosAmor = new ArrayList<Sustantivo>();
    	sustantivosOdio = new ArrayList<Sustantivo>();
    	sustantivosTristeza = new ArrayList<Sustantivo>();
    	sustantivosAlegria = new ArrayList<Sustantivo>();
    	sustantivosDeporte = new ArrayList<Sustantivo>();
    	verbos = new ArrayList<Verbo>();
    	adverbios = new ArrayList<Adverbio>();
    	preposiciones = new ArrayList<Preposicion>();
    	pronombres = new ArrayList<Pronombre>();
    	determinantes = new ArrayList<Determinante>();
    	conjunciones = new ArrayList<Conjuncion>();
    	
    	
  
//    	singular, masculino
        sustantivosAmor.add(new Sustantivo("amor", true, true));
        sustantivosAmor.add(new Sustantivo("corazon", true, true));
        sustantivosAmor.add(new Sustantivo("besos", false,true));
        sustantivosAmor.add(new Sustantivo("boca",true, false));
        sustantivosAmor.add(new Sustantivo("ojos", false,true));
        sustantivosAmor.add(new Sustantivo("fuego", true, true));
        sustantivosAmor.add(new Sustantivo("alma", true,false));
        sustantivosAmor.add(new Sustantivo("forma", true, false));
        sustantivosAmor.add(new Sustantivo("felicidad", true, false));
        sustantivosAmor.add(new Sustantivo("prueba", true,false));
        sustantivosAmor.add(new Sustantivo("locura", true, false));
        sustantivosAmor.add(new Sustantivo("pensamiento", true, true));
        sustantivosAmor.add(new Sustantivo("pasion", true, false));
        sustantivosAmor.add(new Sustantivo("pasiones", false, false));
        sustantivosAmor.add(new Sustantivo("mujer", true, false));
        sustantivosAmor.add(new Sustantivo("hombre", true, true));
        sustantivosAmor.add(new Sustantivo("luna", true, false));
        sustantivosAmor.add(new Sustantivo("ser", true, true));
        sustantivosAmor.add(new Sustantivo("seres", false,true));
        sustantivosAmor.add(new Sustantivo("verdad", true,false));
        sustantivosAmor.add(new Sustantivo("promesa", true,false));
        sustantivosAmor.add(new Sustantivo("pasion", true,false));
        sustantivosAmor.add(new Sustantivo("pasiones", false,false));
        sustantivosAmor.add(new Sustantivo("ser", true,true));
        sustantivosAmor.add(new Sustantivo("seres", false,true));
        sustantivosAmor.add(new Sustantivo("existencia", true,false));
         
        
        
        
     
//    	singular, masculino
        sustantivosOdio.add(new Sustantivo("odio", true, true));
        sustantivosOdio.add(new Sustantivo("infierno", true, true));
        sustantivosOdio.add(new Sustantivo("alma", true, false));
        sustantivosOdio.add(new Sustantivo("decadencia", true,false));
        sustantivosOdio.add(new Sustantivo("temor", true, true));
        sustantivosOdio.add(new Sustantivo("temores", false, true));
        sustantivosOdio.add(new Sustantivo("temores", false, true));
        sustantivosOdio.add(new Sustantivo("rencor", true, true));
        sustantivosOdio.add(new Sustantivo("repulsion", true, false));
        sustantivosOdio.add(new Sustantivo("cenizas", false, false));
        sustantivosOdio.add(new Sustantivo("olvido", true, true));
        sustantivosOdio.add(new Sustantivo("desprecio", true, true));
        sustantivosOdio.add(new Sustantivo("infelicidad", true, false));
        sustantivosOdio.add(new Sustantivo("calamidad", true, false));
        sustantivosOdio.add(new Sustantivo("calamidades", false, false));
        sustantivosOdio.add(new Sustantivo("guerra", true, false));
        sustantivosOdio.add(new Sustantivo("guerras", true, false));
        sustantivosOdio.add(new Sustantivo("vomito", true, true));
        sustantivosOdio.add(new Sustantivo("existencia", true, false));
        sustantivosOdio.add(new Sustantivo("violento", true, true));
        sustantivosOdio.add(new Sustantivo("violentos", false, true));
        sustantivosOdio.add(new Sustantivo("violencia", true, false));
        sustantivosOdio.add(new Sustantivo("rencor", true, true));
        sustantivosOdio.add(new Sustantivo("aversion", true, false));
        sustantivosOdio.add(new Sustantivo("abominacion", true, false));
        sustantivosOdio.add(new Sustantivo("aversiones", false, false));
        sustantivosOdio.add(new Sustantivo("antipatia", true, false));
        sustantivosOdio.add(new Sustantivo("mentira", true, false));
        sustantivosOdio.add(new Sustantivo("venganza", true, false));
        sustantivosOdio.add(new Sustantivo("mentiras", false, false));
        sustantivosOdio.add(new Sustantivo("despecho", true, true));
        sustantivosOdio.add(new Sustantivo("veneno", true, true));
        sustantivosOdio.add(new Sustantivo("sombra", true, false));
//        sustantivosOdio.add(new Sustantivo("amor", true, true));
//        sustantivosOdio.add(new Sustantivo("amor", true, true));
//        sustantivosOdio.add(new Sustantivo("amor", true, true));
//        
        
        sustantivosDeporte.add(new Sustantivo("futbol", true, true));
        sustantivosDeporte.add(new Sustantivo("aventura", true, false));
        sustantivosDeporte.add(new Sustantivo("ajedrez", true, true));
        sustantivosDeporte.add(new Sustantivo("boxeo", true, true));
        sustantivosDeporte.add(new Sustantivo("autos", false, true));        
        sustantivosDeporte.add(new Sustantivo("motos", false, true));
        sustantivosDeporte.add(new Sustantivo("golf", true, true));
        sustantivosDeporte.add(new Sustantivo("voleibol", true, true));
        sustantivosDeporte.add(new Sustantivo("natacion", true, false));
        sustantivosDeporte.add(new Sustantivo("atletismo", true, true));
        sustantivosDeporte.add(new Sustantivo("olimpiadas", false, false));
        sustantivosDeporte.add(new Sustantivo("hockey", true, true));
        sustantivosDeporte.add(new Sustantivo("rugby", true, true));
        sustantivosDeporte.add(new Sustantivo("ciclismo", true, true));
        sustantivosDeporte.add(new Sustantivo("corazon", true, true));
        sustantivosDeporte.add(new Sustantivo("partido", true, true));
        sustantivosDeporte.add(new Sustantivo("victoria", true, false));

        sustantivosDeporte.add(new Sustantivo("futbolista", true, true));
        sustantivosDeporte.add(new Sustantivo("aventurero", true, false));
        sustantivosDeporte.add(new Sustantivo("ajedrez", true, true));
        sustantivosDeporte.add(new Sustantivo("boxeoador", true, true));
        sustantivosDeporte.add(new Sustantivo("boxeoadora", true, false));
        sustantivosDeporte.add(new Sustantivo("automovilista", true, true));        
        sustantivosDeporte.add(new Sustantivo("motos", false, true));
        sustantivosDeporte.add(new Sustantivo("golfista", true, true));
        sustantivosDeporte.add(new Sustantivo("voleibol", true, true));
        sustantivosDeporte.add(new Sustantivo("nadadora", true, false));
        sustantivosDeporte.add(new Sustantivo("atletismo", true, true));
        sustantivosDeporte.add(new Sustantivo("olimpiadas", false, false));
        sustantivosDeporte.add(new Sustantivo("hockey", true, true));
        sustantivosDeporte.add(new Sustantivo("rugby", true, true));
        sustantivosDeporte.add(new Sustantivo("ciclista", true, false));
        sustantivosDeporte.add(new Sustantivo("corazon", true, true));
        sustantivosDeporte.add(new Sustantivo("partido", true, true));
        sustantivosDeporte.add(new Sustantivo("partidos", false, true));
        
        
        sustantivosTristeza.add(new Sustantivo("melancolia", true, false));
        sustantivosTristeza.add(new Sustantivo("melancolias", false, false));
        sustantivosTristeza.add(new Sustantivo("lagrimas", false, false));
        sustantivosTristeza.add(new Sustantivo("lagrima", true, false));
        sustantivosTristeza.add(new Sustantivo("distancia", true, false));
        sustantivosTristeza.add(new Sustantivo("indiferencia", true, false));
        sustantivosTristeza.add(new Sustantivo("tristeza", true, false));
        sustantivosTristeza.add(new Sustantivo("pena", true, false));
        sustantivosTristeza.add(new Sustantivo("desanimo", true, true));
        sustantivosTristeza.add(new Sustantivo("abatimiento", true, true));
        sustantivosTristeza.add(new Sustantivo("depresion", true, false));
        sustantivosTristeza.add(new Sustantivo("desconsuelo", true, true));
        sustantivosTristeza.add(new Sustantivo("nostalgia", true, false));
        sustantivosTristeza.add(new Sustantivo("amargura", true, false));
        sustantivosTristeza.add(new Sustantivo("desdicha", true, false));
        sustantivosTristeza.add(new Sustantivo("pesar", true, true));
        sustantivosTristeza.add(new Sustantivo("desdichas", false, false));
        sustantivosTristeza.add(new Sustantivo("pesares", false, true));
        sustantivosTristeza.add(new Sustantivo("quebranto", true, true));
        sustantivosTristeza.add(new Sustantivo("tormenta", true, false));
        sustantivosTristeza.add(new Sustantivo("espiritu", true, true));
        sustantivosTristeza.add(new Sustantivo("dolor", true, true));
        sustantivosTristeza.add(new Sustantivo("penas", false, false));
        sustantivosTristeza.add(new Sustantivo("tristeza", true, false));
        sustantivosTristeza.add(new Sustantivo("melancolia", true, false));
        sustantivosTristeza.add(new Sustantivo("melancolia", true, false));
        sustantivosTristeza.add(new Sustantivo("melancolia", true, false));
        sustantivosTristeza.add(new Sustantivo("tristeza", true, false));
        
        
        
        sustantivosAlegria.add(new Sustantivo("alegria", true, false));
        sustantivosAlegria.add(new Sustantivo("corazon", true, true));
        sustantivosAlegria.add(new Sustantivo("entusiasmo", true, true));
        sustantivosAlegria.add(new Sustantivo("felicidad", true, false));
        sustantivosAlegria.add(new Sustantivo("diversion", true, false));
        sustantivosAlegria.add(new Sustantivo("corazones", false, true));
        sustantivosAlegria.add(new Sustantivo("satisfaccion", true, false));
        sustantivosAlegria.add(new Sustantivo("risa", true, false));
        sustantivosAlegria.add(new Sustantivo("paraiso", true, true));
        sustantivosAlegria.add(new Sustantivo("alegria", true, false));
        
        
        
        
        /* *********************************************** */
        /* ******************* Verbos ******************** */
        /* *********************************************** */
        
        verbos.add(new Verbo("enseña", "enseñan", "enseño"));
        verbos.add(new Verbo("mira", "miran", "miro"));
        verbos.add(new Verbo("come", "comen", "comio"));
        verbos.add(new Verbo("corre", "corren", "corrio"));
        verbos.add(new Verbo("ama", "aman", "amo"));
        verbos.add(new Verbo("quiere", "quieren", "quiso"));
        verbos.add(new Verbo("entiende", "entienden", "entendio"));
        verbos.add(new Verbo("es", "son", "fueron"));
        verbos.add(new Verbo("camina", "caminan", "caminaron"));
        verbos.add(new Verbo("extraña", "extrañan", "extrañaron"));
        verbos.add(new Verbo("perdona", "perdonan", "perdonaron"));
        verbos.add(new Verbo("desea", "desean", "deseo"));
        verbos.add(new Verbo("necesita", "necesitan", "necesito"));
        verbos.add(new Verbo("muestra", "muestran", "mostro"));
        verbos.add(new Verbo("pertenece", "pertenecen", "pertenecio"));
        verbos.add(new Verbo("tiene", "tiene", "tuvo"));
        verbos.add(new Verbo("olvida", "olvidan", "olvido"));
        verbos.add(new Verbo("espera", "esperaron", "espero"));
        verbos.add(new Verbo("ayuda", "ayudan", "ayudo"));
        verbos.add(new Verbo("termina", "terminan", "termino"));
        verbos.add(new Verbo("nace", "nacen", "nacio"));
        verbos.add(new Verbo("guarda", "guardan", "guardo"));
        verbos.add(new Verbo("deja", "dejan", "dejo"));
        verbos.add(new Verbo("coquetea", "coquetean", "coqueteo"));
        verbos.add(new Verbo("grita", "gritan", "grito"));
        verbos.add(new Verbo("llora", "lloran", "lloro"));
        verbos.add(new Verbo("promete", "prometen", "prometio"));
        verbos.add(new Verbo("lee", "leen", "leyo"));
//        verbos.add(new Verbo("swims", "swim", "swam"));
        verbos.add(new Verbo("escribe", "escriben", "escribio"));
        verbos.add(new Verbo("entretiene", "entretienen", "entretuvo"));
        verbos.add(new Verbo("palpita", "palpitan", "palpito"));
        verbos.add(new Verbo("disfruta", "disfrutan", "disfruto"));
        verbos.add(new Verbo("salta", "saltan", "saltaron"));
//        verbos.add(new Verbo("yells", "yell", "yelled"));
//        verbos.add(new Verbo("pinta", "paint", "painted"));
        verbos.add(new Verbo("ama", "aman", "amo")); 
        verbos.add(new Verbo("desprecia", "desprecian", "desprecio"));
//        verbos.add(new Verbo("screams", "scream", "screamed"));
//        verbos.add(new Verbo("discombobulates", "discombobulate", "discombobulated"));        
        verbos.add(new Verbo("interrumpe", "interrumpen", "interrumpio"));  
        verbos.add(new Verbo("enciende", "encienden", "encendio"));
        verbos.add(new Verbo("deja", "dejan", "dejo"));
        verbos.add(new Verbo("aguarda", "aguardan", "aguardo"));
        verbos.add(new Verbo("alberga", "albergan", "albergo"));
        verbos.add(new Verbo("engendra", "engendran", "engendro"));
        verbos.add(new Verbo("muere", "mueren", "murio"));

//        verbos.add(new Verbo("ostracizes", "ostracize", "ostracized"));   
        

        /* *********************************************** */
        /* ******************* Adjetivos ***************** */
        /* *********************************************** */
//        masculino, femenino, masculinoPlural, masculinoSingular, unisex
        adjetivos.add(new Adjetivo("misterioso","misteriosa","misteriosos", "misteriosas"));
        adjetivos.add(new Adjetivo("misterio","misterios"));
        adjetivos.add(new Adjetivo("enamorado","enamorada","enamorados", "enamoradas"));
        adjetivos.add(new Adjetivo("franco","franca","francos","francas"));
        adjetivos.add(new Adjetivo("expresivo","expresiva","expresivos","expresivas"));
        adjetivos.add(new Adjetivo("cariñoso","cariñosa","cariñosos","cariñosas"));
        adjetivos.add(new Adjetivo("calido","calida","calidos","calidas"));
        adjetivos.add(new Adjetivo("benigno","benigna","benignos","benignas"));
        adjetivos.add(new Adjetivo("magico","magica","magicos","magicas"));
        adjetivos.add(new Adjetivo("amante","amantes","amante","amantes"));
        adjetivos.add(new Adjetivo("dificil","dificiles","dificil","dificiles"));
        adjetivos.add(new Adjetivo("facil","faciles","facil","faciles"));
        adjetivos.add(new Adjetivo("loco","loca","locos","locas"));
        adjetivos.add(new Adjetivo("gemelo","gemela","gemelos","gemelas"));
        adjetivos.add(new Adjetivo("feliz","felices","feliz","felices"));
        adjetivos.add(new Adjetivo("verdadero","verdadera","verdaderos","verdaderas"));
        adjetivos.add(new Adjetivo("sufrido","sufrida","sufridos","sufridas"));
        adjetivos.add(new Adjetivo("noble","nobles","noble","nobles"));
        adjetivos.add(new Adjetivo("fiel","fieles","fiel","fieles"));       
        adjetivos.add(new Adjetivo("retorico","retoricas","retoricos","retoricas"));
        adjetivos.add(new Adjetivo("entretenido","entretenida","entretenidos","entretenidas"));
        adjetivos.add(new Adjetivo("fabuloso","fabulosa","fabulosos","fabulosas"));
        adjetivos.add(new Adjetivo("hermoso","hermosa","hermosos","hermosas"));
        adjetivos.add(new Adjetivo("tentador","tentadora","tentadores","tentadoras"));
        adjetivos.add(new Adjetivo("feo","fea","feos","feas"));
        adjetivos.add(new Adjetivo("delicioso","deliciosa","deliciosos","deliciosas"));
        adjetivos.add(new Adjetivo("atractivo","atractiva","atractivos","atractivas"));
        adjetivos.add(new Adjetivo("saludable","saludables","saludable","saludables"));
        adjetivos.add(new Adjetivo("peligroso","peligrosa","peligrosos","peligrosas"));
        adjetivos.add(new Adjetivo("languido","languida","languidos","languidas"));
        adjetivos.add(new Adjetivo("indiferente","indiferentes","indiferente","indiferentes"));
        adjetivos.add(new Adjetivo("maravilloso","maravillosa","maravillosos","maravillosas"));
        adjetivos.add(new Adjetivo("aterrador","aterradora","ateradores","aterradoras"));
        adjetivos.add(new Adjetivo("aterrador","aterradora","ateradores","aterradoras"));
        adjetivos.add(new Adjetivo("miedo","miedos","miedo","miedos"));
        adjetivos.add(new Adjetivo("insinuante","insinuantes","insinuante","insinuantes"));
        adjetivos.add(new Adjetivo("lisonjero","lisonjera","lisongeros","lisongeras"));
        adjetivos.add(new Adjetivo("alagador","alagadora","alagadores","alagadoras"));
        adjetivos.add(new Adjetivo("extasiado","extasiada","extasiados","extasiadas"));
        adjetivos.add(new Adjetivo("desquiciado","desquiciada","desquiciados","desquiciadas"));  
        adjetivos.add(new Adjetivo("locura","locuras","locura","locuras"));
        adjetivos.add(new Adjetivo("locura","locuras","locura","locuras"));
        adjetivos.add(new Adjetivo("transtornado","transtornada","transtornado","transtornada"));   
        adjetivos.add(new Adjetivo("glamoroso","glamorosa","glamorosos","glamorosas"));        
        adjetivos.add(new Adjetivo("difuso","difusa","difusos","difusas"));
        adjetivos.add(new Adjetivo("borroso","borrosa","borrosos","borosas"));
        adjetivos.add(new Adjetivo("perverso","perversa","perversos","perversas"));
        adjetivos.add(new Adjetivo("apasionado","apasionada","apasionados","apasionadas"));
        adjetivos.add(new Adjetivo("pequeño","pequeña","pequeños","pequeñas"));
        adjetivos.add(new Adjetivo("ciego","ciega","ciegos","ciegas"));
        adjetivos.add(new Adjetivo("enfermo","enferma","enfermos","enfermas"));
        adjetivos.add(new Adjetivo("ruin","ruines","ruin","ruines"));
        adjetivos.add(new Adjetivo("debil","deviles","debil","deviles"));	
        adjetivos.add(new Adjetivo("abatido","abatida","abatidos","abatidas"));
        adjetivos.add(new Adjetivo("cansado","cansada","cansados","cansadas"));
        adjetivos.add(new Adjetivo("desgastado","desgastada","desgastados","desgastadas"));
        adjetivos.add(new Adjetivo("perfecto","perfecta","perfectos","perfectas"));
        adjetivos.add(new Adjetivo("obstinado","obstinada","obstinados","obstinadas"));
        
        
        
        adjetivosFuertes.add(new Adjetivo("incompetente","incompetente","incompetentes","incompetentes"));
        adjetivosFuertes.add(new Adjetivo("mediocre","mediocre","mediocres","mediocres"));
        adjetivosFuertes.add(new Adjetivo("corrupto","corrupta","corruptos","corruptas"));
        adjetivosFuertes.add(new Adjetivo("insufrible","insufrible","insufribles","insufribles"));
        adjetivosFuertes.add(new Adjetivo("canalla","canalla","canallas","canallas"));
        adjetivosFuertes.add(new Adjetivo("incompetente","incompetente","incompetentes","incompetentes"));
        adjetivosFuertes.add(new Adjetivo("atorrante","atorrante","atorrantes","atorrantes"));
        adjetivosFuertes.add(new Adjetivo("otario","otario","otarios","otarios"));
        adjetivosFuertes.add(new Adjetivo("boludo","boluda","boludos","boludas"));
        adjetivosFuertes.add(new Adjetivo("descabellado","descabellada","descabellados","descabelladas"));
        adjetivosFuertes.add(new Adjetivo("patetico","patetica","pateticos","pateticas"));
        adjetivosFuertes.add(new Adjetivo("inepto","inepta","ineptos","ineptas"));
        adjetivosFuertes.add(new Adjetivo("desgraciado","desgraciada","desgraciados","desgraciadas"));
        adjetivosFuertes.add(new Adjetivo("inepto","inepta","ineptos","ineptas"));
        adjetivosFuertes.add(new Adjetivo("canalla","canallas","canalla","canallas"));
        adjetivosFuertes.add(new Adjetivo("bribon","bribon","bribones","bribonas"));
        adjetivosFuertes.add(new Adjetivo("inepto","inepta","ineptos","ineptas"));

        
        //      a.add(new Adjective(""));
        
        
        /* *********************************************** */
        /* ******************* Preposicion *************** */
        /* *********************************************** */
        preposiciones.add(new Preposicion("de"));
        preposiciones.add(new Preposicion("en"));
        preposiciones.add(new Preposicion("a"));
        preposiciones.add(new Preposicion("sobre"));
        preposiciones.add(new Preposicion("con"));
        preposiciones.add(new Preposicion("dentro"));
        preposiciones.add(new Preposicion("donde"));
        
        /* ************************************** */
        /* ************ Menos usados ************ */
        preposiciones.add(new Preposicion("junto"));
        preposiciones.add(new Preposicion("alrededor"));
        preposiciones.add(new Preposicion("encima"));
        preposiciones.add(new Preposicion("frente"));
        preposiciones.add(new Preposicion("Atras"));
        preposiciones.add(new Preposicion("adelante"));
        preposiciones.add(new Preposicion("incluso"));
        
        /* *********************************************** */
        /* ******************* Adverbios   *************** */
        /* *********************************************** */
        
        
        adverbios.add(new Adverbio("jamas"));
        adverbios.add(new Adverbio("tan"));
        adverbios.add(new Adverbio("nunca"));
        adverbios.add(new Adverbio("pronto"));
        adverbios.add(new Adverbio("antes"));
        adverbios.add(new Adverbio("a menudo"));
        adverbios.add(new Adverbio("despues"));
        adverbios.add(new Adverbio("luego"));
        adverbios.add(new Adverbio("siempre"));
        adverbios.add(new Adverbio("porque"));
        adverbios.add(new Adverbio("pues"));
        adverbios.add(new Adverbio("que"));
        adverbios.add(new Adverbio("dado que"));
        adverbios.add(new Adverbio("a causa de que"));
        adverbios.add(new Adverbio("puesto que"));
        adverbios.add(new Adverbio("algo"));
        adverbios.add(new Adverbio("bastante"));
        adverbios.add(new Adverbio("casi"));
        adverbios.add(new Adverbio("demasiado"));
        adverbios.add(new Adverbio("mas"));
        adverbios.add(new Adverbio("menos"));
        adverbios.add(new Adverbio("mucho"));
        adverbios.add(new Adverbio("muy"));
        adverbios.add(new Adverbio("nada"));
        adverbios.add(new Adverbio("poco"));
        adverbios.add(new Adverbio("solo"));
        adverbios.add(new Adverbio("solamente"));
        adverbios.add(new Adverbio("todo"));
//        adverbios.add(new Adverbio("tanto"));
        adverbios.add(new Adverbio("asi"));
        adverbios.add(new Adverbio("bien"));
        adverbios.add(new Adverbio("despacio"));
        adverbios.add(new Adverbio("dificilmente"));
        adverbios.add(new Adverbio("estupendamente"));
        adverbios.add(new Adverbio("facilmente"));
        adverbios.add(new Adverbio("especialmente"));
        adverbios.add(new Adverbio("mal"));
        adverbios.add(new Adverbio("mejor"));
        adverbios.add(new Adverbio("peor"));
//        adverbios.add(new Adverbio("regular"));
        adverbios.add(new Adverbio("efectivamente"));
        adverbios.add(new Adverbio("seguramente"));
        adverbios.add(new Adverbio("si"));
        adverbios.add(new Adverbio("tambien"));
        adverbios.add(new Adverbio("verdaderamente"));
        adverbios.add(new Adverbio("jamas"));
        adverbios.add(new Adverbio("no"));
        adverbios.add(new Adverbio("nunca"));
        adverbios.add(new Adverbio("tampoco"));
        adverbios.add(new Adverbio("en absoluto"));
        adverbios.add(new Adverbio("probablemente"));
        adverbios.add(new Adverbio("quizas"));
        adverbios.add(new Adverbio("seguramente"));
//        adverbios.add(new Adverbio("tal"));
        adverbios.add(new Adverbio("tal vez"));

        
        /* *********************************************** */
        /* ******************* Pronombres  *************** */
        /* *********************************************** */
        pronombres.add(new Pronombre("este","esta","estos","estas"));              
        pronombres.add(new Pronombre("el","ella","ellos","ellas"));      
        
        /* *********************************************** */
        /* ******************* Determinante*************** */
        /* *********************************************** */
        determinantes.add(new Determinante("el","la","los","las"));
        determinantes.add(new Determinante("aquel", "aquella", "aquellos","aquellas"));        
        determinantes.add(new Determinante("un","una", "unos","unas"));        
        
        
        /* *********************************************** */
        /* ******************* Conjunciones ************** */
        /* *********************************************** */
        conjunciones.add(new Conjuncion("y"));
        conjunciones.add(new Conjuncion("o"));
        conjunciones.add(new Conjuncion("mientras"));
        conjunciones.add(new Conjuncion("porque"));
        
        
	}
    
    
    
    
    
    /* *********************************************** */
    /* ******************* ADDPALABRAS  *************** */
    /* *********************************************** */




	public void addAdjetivo(Adjetivo x) { adjetivos.add(x); }
	public void addAdjetivoIntermedios(Adjetivo x) { adjetivosFuertes.add(x); }
	public void addAdjetivoFuertes(Adjetivo x) { adjetivosFuertes.add(x); }
    public void addSustantivoAmor(Sustantivo x) { sustantivosAmor.add(x); }
    public void addSustantivoOdio(Sustantivo x) { sustantivosOdio.add(x); }
    public void addSustantivoTristeza(Sustantivo x) { sustantivosTristeza.add(x); }
    public void addSustantivoAlegria(Sustantivo x) { sustantivosAlegria.add(x); }
    public void addSustantivoDeporte(Sustantivo x) { sustantivosDeporte.add(x); }
    public void addVerbo(Verbo x) { verbos.add(x); }
    public void addAdverbio(Adverbio x) { adverbios.add(x); }
    public void addDeterminante(Determinante x) { determinantes.add(x); }
    public void addPreposicion(Preposicion x) { preposiciones.add(x); }
    public void addPronombre(Pronombre x) { pronombres.add(x); }
    public void addPronombre(Conjuncion x) { conjunciones.add(x); }
    
    
    
    /* *********************************************** */
    /* *******************             *************** */
    /* *********************************************** */
    public String getSustantivo(String tema) {  
    	String sus ="";
    	if (tema.equals("Amor")) {
    		sus =sustantivo(sustantivosAmor).getSustantivo();    		
		}else if (tema.equals("Odio")) {
			sus =sustantivo(sustantivosOdio).getSustantivo();
		}else if (tema.equals("Tristeza")) {
			sus =sustantivo(sustantivosTristeza).getSustantivo();
		}else if (tema.equals("Alegria")) {
			sus =sustantivo(sustantivosAlegria).getSustantivo();
		}else if (tema.equals("Deporte")) {
			sus =sustantivo(sustantivosDeporte).getSustantivo();
		}       
        return sus;
    }
    
    






	public Sustantivo sustantivo(ArrayList<Sustantivo> sustantivos){
		int index = (int)(Math.random()*sustantivos.size());
        Sustantivo sustantivo = sustantivos.get(index);
        
        singular = sustantivo.isSingular();
        masculino = sustantivo.isMasculino();
    	
    	return sustantivo;
    }
    public String getDeterminante(boolean isSingular, boolean isMasculino) {        
        int index = (int)(Math.random()*determinantes.size());
        Determinante determinante = determinantes.get(index);
        String det ="";
        if (isSingular) {
			if (isMasculino) {
				det = determinante.getDetMasculinoSingular();
			}else{
				det = determinante.getDetFemeninoSingular();
			}
		}else{
			if (isMasculino) {
				det = determinante.getDetMasculinoPlural();
			}else{
				det = determinante.getDetFemeninoPlural();
			}			
		}
        return det;
    }
    
    
    public String getAdjetivo(boolean isSingular, boolean isMasculino, String agresibidad) {   
    	String adj ="";
    	if (agresibidad.equals("alto")) {
    		 int index = (int)(Math.random()*adjetivosFuertes.size());
    	        Adjetivo adjetivo = adjetivosFuertes.get(index);
    	        
    	        if (isSingular) {
    				if (isMasculino) {
    					adj = adjetivo.getAdjmasculino();
    				}else{
    					adj = adjetivo.getAdjfemenino();
    				}
    			}else{
    				if (isMasculino) {
    					adj = adjetivo.getAdjMaculinoPlural();
    				}else{
    					adj = adjetivo.getAdjFemeninoPlural();
    				}			
    			}
		}else if (agresibidad.equals("bajo")) {
   		 int index = (int)(Math.random()*adjetivos.size());
   	        Adjetivo adjetivo = adjetivos.get(index);
   	        
   	        if (isSingular) {
   				if (isMasculino) {
   					adj = adjetivo.getAdjmasculino();
   				}else{
   					adj = adjetivo.getAdjfemenino();
   				}
   			}else{
   				if (isMasculino) {
   					adj = adjetivo.getAdjMaculinoPlural();
   				}else{
   					adj = adjetivo.getAdjFemeninoPlural();
   				}			
   			}
		}
       
        return adj;
    }

    
    public String getAdverbio() {        
        int index = (int)(Math.random()*adverbios.size());
        Adverbio adverbio = adverbios.get(index);
        String adv = adverbio.getAdv();
        return adv;
    }
    
    
    public String getVerbo(boolean isSingular) {        
        int index = (int)(Math.random()*verbos.size());
       
        String verb ="";

            if (isSingular)
                verb = verbos.get(index).getSingular();
            else
                verb = verbos.get(index).getPlural();
//        }

        return verb;
    }
    public String getVerboPas(boolean isSingular) {        
        int index = (int)(Math.random()*verbos.size());
       
        String verb ="";
            if (isSingular)
                verb = verbos.get(index).getPast();
            else
                verb = verbos.get(index).getPast()+"n";
//        }

        return verb;
    }
    
    public String getPreposicion() {        
        int index = (int)(Math.random()*preposiciones.size());
        return preposiciones.get(index).getPrep();
    }
    
    public String getConjuncion() {        
        int index = (int)(Math.random()*conjunciones.size());
        return conjunciones.get(index).getConjuncion();
    }
    
    public String getPronombre(boolean isSingular, boolean isMasculino) {        
        int index = (int)(Math.random()*pronombres.size());
        Pronombre pronombre = pronombres.get(index);
        String pron ="";
        if (isSingular) {
			if (isMasculino) {
				pron = pronombre.getPronMasculinoSingular();
			}else{
				pron = pronombre.getPronFemeninoSingular();
			}
		}else{
			if (isMasculino) {
				pron = pronombre.getPronMasculinoPlural();
			}else{
				pron = pronombre.getPronFemeninoPlural();
			}			
		}
        return pron;
    }





	public ArrayList<Adjetivo> getAdjetivos() {
		return adjetivos;
	}





	public ArrayList<Adjetivo> getAdjetivosIntermedios() {
		return adjetivosFuertes;
	}





	public ArrayList<Adjetivo> getAdjetivosFuertes() {
		return adjetivosFuertes;
	}





	public ArrayList<Sustantivo> getSustantivosAmor() {
		return sustantivosAmor;
	}





	public ArrayList<Sustantivo> getSustantivosOdio() {
		return sustantivosOdio;
	}





	public ArrayList<Sustantivo> getSustantivosTristeza() {
		return sustantivosTristeza;
	}





	public ArrayList<Sustantivo> getSustantivosAlegria() {
		return sustantivosAlegria;
	}





	public ArrayList<Sustantivo> getSustantivosDeporte() {
		return sustantivosDeporte;
	}





	public ArrayList<Verbo> getVerbos() {
		return verbos;
	}





	public ArrayList<Adverbio> getAdverbios() {
		return adverbios;
	}





	public ArrayList<Preposicion> getPreposiciones() {
		return preposiciones;
	}





	public ArrayList<Pronombre> getPronombres() {
		return pronombres;
	}





	public ArrayList<Determinante> getDeterminantes() {
		return determinantes;
	}





	public ArrayList<Conjuncion> getConjunciones() {
		return conjunciones;
	}





	public boolean isSingular() {
		return singular;
	}





	public boolean isMasculino() {
		return masculino;
	} 

}




