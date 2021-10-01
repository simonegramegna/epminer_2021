<h1> Documentazione </h1>

<p> Il progetto è stato realizzato da: </p>

<ul>
    <li>Simone Gramegna (717041) mail: s.gramegna5@studenti.uniba.it
    </li>
    <li> Federico Canistro (723320) mail: f.canistro@studenti.uniba.it</li></ul>

<p> Il software realizzato utilizza l'algoritmo Apriori per scoprire pattern frequenti e pattern emergenti elaborando dati estratti da tabelle di database utilizzando il servizio MySQL </p>

<p>
    I dati di input dell'algoritmo sono:
</p>

<ul>
    <li>una collezione D di transazioni</li>
    <li>Ogni transazione è un vettore di coppie attributo-valore (item)</li>
    <li>Un minimo supporto minS</li>
</ul>

<p> Lo scopo è identificare gli insiemi di item (itemset o pattern) che occorrono con una frequenza minima (>= minS) in D </p>

<p> L'algoritmo ha applicazione nella market basket analysis per scoprire ad esempio i prodotti che compaiono spesso in uno stesso scontrino </p>

<p> I passi dall'algoritmo sono i seguenti: <p>
<ol>
    <li>Prende in input la tabella Target e la tabella </li>
</ol>

<h2> Guida di Installazione </h2>

<h3> Requisiti server </h3>

<p> Per utilizzare il server è necessario: </p>

<ul>
    <li>Installare MYSql sul proprio computer</li>
    <li>Eseguire lo script sql (mysqlScript.sql) presetne nel percorso "../server/sql"</li>
    <li>Installare JRE 8</li>
    <li>Installare Maven  <a href="https://maven.apache.org/download.cgi"> (Download di Maven)</a> </li>
</ul>

<h3> Requisiti client ed estensione </h3>

<ul>
    <li>Server in ascolto</li>
    <li>Installare JRE 8</li>
    <li>Installare Maven  <a href="https://maven.apache.org/download.cgi"> (Download di Maven)</a></li>
</ul>

<h2> Guida utente </h2>

<h3> Compilazione e avvio del server </h3>

<ol>
    <li> Eseguire nella cartella /server il comando da terminale <code> mvn clean compile assembly:single </code> </li>
    <li>Il file jar eseguibile si trova nella cartella /target </li>
    <li>Avviare il server eseguendo il comando da terminale <code>java -jar epServer-1.0-jar-with-dependencies.jar</code></li>
    <li>Il server sarà automaticamente in ascolto sulla porta 5000</li>
</ol>

<h3> Compilazione e avvio del client </h3>

<ol>
    <li>Eseguire nella cartella /client il comando da terminale <code>mvn package</code></li>
    <li>Il file jar eseguibile si trova nella cartella /target </li>
    <li>Avviare il client tramite il comando <code>java -jar epClient-1.0.jar</code> specificando l'host (localhost) e la porta (porta di defuallt del server: 5000) </li></ol>

<h3> Compilazione e avvio dell'estensione </h3>

<ol>
    <li>Eseguire nella cartella /estensione il comando da terminale <code>mvn package</code></li>
    <li>Il file jar eseguibile si trova nella cartella /target </li>
    <li>Avviare il programma tramite il comando <code>java -jar epGui-1.0.jar</code></li></ol>

