<h1> Documentazione </h1>

<p> Il progetto è stato realizzato da: </p>

<ul>
    <li>Simone Gramegna (717041) mail: s.gramegna5@studenti.uniba.it
    </li>
    <li> Federico Canistro (723320) mail: f.canistro@studenti.uniba.it</li></ul>
<p> Il software realizzato utilizza l'algoritmo Apriori per scoprire pattern frequenti e pattern emergenti elaborando dati estratti da tabelle di database utilizzando il servizio MySQL. </p>

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

<h4>
     Scoperta di pattern frequenti
</h4>

<p> I dati che ho in input sono i seguenti </p>

<ol>
    <li>Tabella che contiene transazioni <i>target</i></li>
    <li>Tabella che contiene transazioni di <i>background</i></li>
    <li>Un valore minimo di supporto <code>0 < supporto <= 1 </code> </li>
    <li>Un valore minimo di grow rate <code> grow rate >= 1 </code></li></ol>

<p>- Il valore di suppporto in una tabella è cosi calcolato : </p>

$$
\begin{align*}
s(x1,x2..xh) = \frac{p(x1,x2..xk)}{D}
\end{align*}
$$

<p> In cui il valore del numeratore è pari al numero di osservazioni in cui si osserva x1,x2..xk mentre D è il numero totale di transazioni </p><p> - Il grow rate sulle tabelle target e beackground è cosi calcolato : </p>


$$
\begin{align*}
gr(x1,x2..xh) = \frac{sTarget(x1,x2..xh)}{sBackground(x1,x2..xh)} 
\end{align*}
$$

<p> Una volta calcolati questi valori dalle due tabelle <i> target </i> e <i> background </i> il programma esegue due passi per la scopertaa di pattern frequenti:  </p>

<ol>
    <li>Scoprire pattern di lunghezza k a partire da <i>pattern frequenti</i> di lunghezza k-1</li>
    <li>Testare i pattern candidati in <i>Target</i></li>
</ol>

<h4> Scoperta di pattern emergenti </h4>

<p> I pattern frequenti sono calcolati subito dopo i pattern emergenti, calcolando il grow rate in Target rispetto a Background.
    Infine sono selezionati solo i pattern con grow rate superiore alla soglia fissata.
</p>
<h2> Guida di Installazione </h2>

<h3> Requisiti server </h3>

<p> Per utilizzare il server è necessario: </p>

<ul>
    <li>Installare MySql sul proprio computer</li>
    <li>Eseguire lo script sql (mysqlScript.sql) presente nel percorso "../server/sql"</li>
    <li>Installare JRE 8</li>
    <li> <i>Nota: La porta 3306 è preimpostata nel programma per accedere al database </i></li>
</ul>
<h3> Requisiti client ed estensione </h3>

<ul>
    <li>Server in ascolto</li>
    <li>Installare JRE 8</li>
</ul>
<h2> Guida utente </h2>

<h3> Avvio del server </h3>

<ul>
    <li> Nella cartella /jar sono presenti il file .jar e i due script per avviare il programma sia su sistemi GNU\Linux che su sistemi MS-Windows. Per il primo caso basta il comando da shell <code>bash EPserver.sh</code> mentre nel secondo caso basta cliccare sul file EPserver.bat </li>
</ul>
![](C:\Users\Ferdo\Desktop\epminer_2021\screenshots\screen1.png)

<h3> Avvio del client </h3>

<ul>
     <li> Nella cartella /jar sono presenti il file .jar e i due script per avviare il programma sia su sistemi GNU\Linux che su sistemi MS-Windows. Per il primo caso basta il comando da shell <code>bash EPclient.sh</code> mentre nel secondo caso basta cliccare sul file EPclient.bat </li></ul>
![](C:\Users\Ferdo\Desktop\epminer_2021\screenshots\screen3-client.png)

Appena il client si connette, il server accetta la richiesta:

![](C:\Users\Ferdo\Desktop\epminer_2021\screenshots\screen2.png)

<h3> Avvio dell'estensione </h3>

<ul>
     <li> Nella cartella /jar sono presenti il file .jar e i due script per avviare il programma sia su sistemi GNU\Linux che su sistemi MS-Windows. Per il primo caso basta il comando da shell <code>bash EPgui.sh</code> mentre nel secondo caso basta cliccare sul file EPgui.bat </li>
</ul>

![](C:\Users\Ferdo\Desktop\epminer_2021\screenshots\screen4interf.png)

<h3> Guida utilizzo client </h3>

<p> Appena avviato il client, il programma cheide se eseguire una nuova (1) scoperta oppure prendere delle computazioni già presenti in archivio (2)</p>

![](C:\Users\Ferdo\Desktop\epminer_2021\screenshots\s1.png)

<p> Digitando 1 e selezionando una nuova scoperta sulle tabelle, il programma chiede di inserire un valore di minimo supporto (maggiore di zero e minore o uguale a uno), per poi chiedere in input un valore minimo di grow rate (maggiore di zero) </p>

![](C:\Users\Ferdo\Desktop\epminer_2021\screenshots\s2.png)

<p>
    Dopodiché viene richiesto in input il nome della tabella target (playtennisTarget) ed il nome della tabella di background (playtennisBackground)</p>

![](C:\Users\Ferdo\Desktop\epminer_2021\screenshots\s3.png)

<p> In output avrò i prima i Pattern Emergenti e poi i Pattern Frequenti </p>

![](C:\Users\Ferdo\Desktop\epminer_2021\screenshots\s4.png)

![](C:\Users\Ferdo\Desktop\epminer_2021\screenshots\Schermata da 2021-10-23 18-57-08.png)

<p> Selezionando l'opzione 2 (risultati in archivio), i passi del programma sono gli stessi precredenti ma stavolta i risultati dati in output sono caricati da file presenti nella memoria secondaria</p>

![](C:\Users\Ferdo\Desktop\epminer_2021\screenshots\Schermata da 2021-10-23 19-17-57.png)

<p> In entrambi i casi il programma chiede all'utente se vuole continuare per altre computazioni </p>

<p> Selezionando n (no) , il client termina l'esecuzione e viene chiuso </p>

<h3>
    Guida utilizzo estensione
</h3>

<p> La finestra principale presenta tre bottoni: uno per avviare una nuova scoperta, uno per prendere dei risultati in archivio e l'ultimo per uscire dal programma. Il client stavolta si connette in automatico alla porta di default del server </p>

![](C:\Users\Ferdo\Desktop\epminer_2021\screenshots\Schermata da 2021-10-10 14-19-39.png)

<p> Cliccando sia su <i> Nuova scoperta </i> che su <i> Risultati in archivio </i> la finestra mostra una nuova schermata in cui è possibile inserire i valori di minimo supporto e di grow rate. Se i valori sono errati e non soddisfano l'intervallo richiesto, una serie di alert compaiono a video inoltre i due input sono resettati. 
Tramite due spinner è possibile selezionare le tabelle target e background già presenti
</p>

![](C:\Users\Ferdo\Desktop\epminer_2021\screenshots\Schermata da 2021-10-10 14-19-47.png)

<p> Tramite il bottone in basso, i dati inseriti, se sono corretti, sono inviati al server, altrimenti compare un messaggio di errore</p>

![](C:\Users\Ferdo\Desktop\epminer_2021\screenshots\Schermata da 2021-10-23 18-25-19.png)

<p> Appena la computazione termina, si apre una finestra di dialogo che mostra i pattern frequenti, i pattern emeergenti inoltre i dati inseriti dall'utente e inviati al server </p>

![](C:\Users\Ferdo\Desktop\epminer_2021\screenshots\Schermata da 2021-10-23 18-24-57.png)

<p> Tramite il bottone in basso è possibile avviare una nuova computazione, ritornando alla finestra principale </p>

<h3> Esempi di test </h3>

Caso Test 1:

Opzione:Nuova scoperta

Valore di minimo supporto:0.2

Valore minimo di Grow Rate:4

Tabella Target:playtennisTarget

Tabella Background:playtennisBackground

Risultati:

Frequent patterns
(outlook=overcast)[0.25]
temperature in [12.12,18.18[[0.25]
(outlook=overcast) AND (play=yes)[0.25]
(outlook=rain) AND temperature in [0.0,6.06[[0.25]
(outlook=rain) AND (umidity=normal)[0.25]
(outlook=rain) AND (wind=weak)[0.25]
(outlook=rain) AND (play=yes)[0.25]
(outlook=sunny) AND temperature in [24.24,30.300098[[0.25]
(outlook=sunny) AND (wind=weak)[0.25]
temperature in [0.0,6.06[ AND (outlook=rain)[0.25]
temperature in [0.0,6.06[ AND (wind=strong)[0.25]
temperature in [0.0,6.06[ AND (play=yes)[0.25]
temperature in [12.12,18.18[ AND (umidity=high)[0.25]
temperature in [12.12,18.18[ AND (wind=weak)[0.25]
temperature in [24.24,30.300098[ AND (outlook=sunny)[0.25]
temperature in [24.24,30.300098[ AND (wind=weak)[0.25]
temperature in [24.24,30.300098[ AND (play=no)[0.25]
(umidity=high) AND temperature in [12.12,18.18[[0.25]
(umidity=high) AND (play=yes)[0.25]
(umidity=normal) AND (outlook=rain)[0.25]
(umidity=normal) AND (wind=strong)[0.25]
(umidity=normal) AND (play=yes)[0.25]
(wind=strong) AND temperature in [0.0,6.06[[0.25]
(wind=strong) AND (umidity=normal)[0.25]
(wind=strong) AND (play=no)[0.25]
(wind=weak) AND (outlook=rain)[0.25]
(wind=weak) AND (outlook=sunny)[0.25]
(wind=weak) AND temperature in [12.12,18.18[[0.25]
(wind=weak) AND temperature in [24.24,30.300098[[0.25]
(wind=weak) AND (play=no)[0.25]
(play=no) AND temperature in [24.24,30.300098[[0.25]
(play=no) AND (wind=strong)[0.25]
(play=no) AND (wind=weak)[0.25]
(play=yes) AND (outlook=overcast)[0.25]
(play=yes) AND (outlook=rain)[0.25]
(play=yes) AND temperature in [0.0,6.06[[0.25]
(play=yes) AND (umidity=high)[0.25]
(play=yes) AND (umidity=normal)[0.25]
(outlook=rain) AND temperature in [0.0,6.06[ AND (umidity=normal)[0.25]
(outlook=rain) AND (umidity=normal) AND temperature in [0.0,6.06[[0.25]
(outlook=rain) AND (wind=weak) AND (play=yes)[0.25]
(outlook=rain) AND (play=yes) AND (wind=weak)[0.25]
(outlook=sunny) AND temperature in [24.24,30.300098[ AND (umidity=high)[0.25]
(outlook=sunny) AND temperature in [24.24,30.300098[ AND (play=no)[0.25]
(outlook=sunny) AND (umidity=high) AND temperature in [24.24,30.300098[[0.25]
(outlook=sunny) AND (umidity=high) AND (wind=weak)[0.25]
(outlook=sunny) AND (wind=weak) AND (umidity=high)[0.25]
(outlook=sunny) AND (wind=weak) AND (play=no)[0.25]
(outlook=sunny) AND (play=no) AND temperature in [24.24,30.300098[[0.25]
(outlook=sunny) AND (play=no) AND (wind=weak)[0.25]
temperature in [0.0,6.06[ AND (outlook=rain) AND (umidity=normal)[0.25]
temperature in [0.0,6.06[ AND (umidity=normal) AND (outlook=rain)[0.25]
temperature in [0.0,6.06[ AND (umidity=normal) AND (wind=strong)[0.25]
temperature in [0.0,6.06[ AND (umidity=normal) AND (play=yes)[0.25]
temperature in [0.0,6.06[ AND (wind=strong) AND (umidity=normal)[0.25]
temperature in [0.0,6.06[ AND (play=yes) AND (umidity=normal)[0.25]
temperature in [12.12,18.18[ AND (umidity=high) AND (wind=weak)[0.25]
temperature in [12.12,18.18[ AND (wind=weak) AND (umidity=high)[0.25]
temperature in [24.24,30.300098[ AND (outlook=sunny) AND (umidity=high)[0.25]
temperature in [24.24,30.300098[ AND (outlook=sunny) AND (play=no)[0.25]
temperature in [24.24,30.300098[ AND (umidity=high) AND (outlook=sunny)[0.25]
temperature in [24.24,30.300098[ AND (umidity=high) AND (wind=weak)[0.25]
temperature in [24.24,30.300098[ AND (umidity=high) AND (play=no)[0.25]
temperature in [24.24,30.300098[ AND (wind=weak) AND (umidity=high)[0.25]
temperature in [24.24,30.300098[ AND (play=no) AND (outlook=sunny)[0.25]
temperature in [24.24,30.300098[ AND (play=no) AND (umidity=high)[0.25]
(umidity=high) AND (outlook=sunny) AND temperature in [24.24,30.300098[[0.25]
(umidity=high) AND (outlook=sunny) AND (wind=weak)[0.25]
(umidity=high) AND temperature in [12.12,18.18[ AND (wind=weak)[0.25]
(umidity=high) AND temperature in [24.24,30.300098[ AND (outlook=sunny)[0.25]
(umidity=high) AND temperature in [24.24,30.300098[ AND (wind=weak)[0.25]
(umidity=high) AND temperature in [24.24,30.300098[ AND (play=no)[0.25]
(umidity=high) AND (wind=weak) AND (outlook=sunny)[0.25]
(umidity=high) AND (wind=weak) AND temperature in [12.12,18.18[[0.25]
(umidity=high) AND (wind=weak) AND temperature in [24.24,30.300098[[0.25]
(umidity=high) AND (wind=weak) AND (play=no)[0.25]
(umidity=high) AND (wind=weak) AND (play=yes)[0.25]
(umidity=high) AND (play=no) AND temperature in [24.24,30.300098[[0.25]
(umidity=high) AND (play=no) AND (wind=weak)[0.25]
(umidity=high) AND (play=yes) AND (wind=weak)[0.25]
(umidity=normal) AND (outlook=rain) AND temperature in [0.0,6.06[[0.25]
(umidity=normal) AND temperature in [0.0,6.06[ AND (outlook=rain)[0.25]
(umidity=normal) AND temperature in [0.0,6.06[ AND (wind=strong)[0.25]
(umidity=normal) AND temperature in [0.0,6.06[ AND (play=yes)[0.25]
(umidity=normal) AND (wind=strong) AND temperature in [0.0,6.06[[0.25]
(umidity=normal) AND (play=yes) AND temperature in [0.0,6.06[[0.25]
(wind=strong) AND temperature in [0.0,6.06[ AND (umidity=normal)[0.25]
(wind=strong) AND (umidity=normal) AND temperature in [0.0,6.06[[0.25]
(wind=weak) AND (outlook=rain) AND (play=yes)[0.25]
(wind=weak) AND (outlook=sunny) AND (umidity=high)[0.25]
(wind=weak) AND (outlook=sunny) AND (play=no)[0.25]
(wind=weak) AND temperature in [12.12,18.18[ AND (umidity=high)[0.25]
(wind=weak) AND temperature in [24.24,30.300098[ AND (umidity=high)[0.25]
(wind=weak) AND (umidity=high) AND (outlook=sunny)[0.25]
(wind=weak) AND (umidity=high) AND temperature in [12.12,18.18[[0.25]
(wind=weak) AND (umidity=high) AND temperature in [24.24,30.300098[[0.25]
(wind=weak) AND (umidity=high) AND (play=no)[0.25]
(wind=weak) AND (umidity=high) AND (play=yes)[0.25]
(wind=weak) AND (play=no) AND (outlook=sunny)[0.25]
(wind=weak) AND (play=no) AND (umidity=high)[0.25]
(wind=weak) AND (play=yes) AND (outlook=rain)[0.25]
(wind=weak) AND (play=yes) AND (umidity=high)[0.25]
(play=no) AND (outlook=sunny) AND temperature in [24.24,30.300098[[0.25]
(play=no) AND (outlook=sunny) AND (wind=weak)[0.25]
(play=no) AND temperature in [24.24,30.300098[ AND (outlook=sunny)[0.25]
(play=no) AND temperature in [24.24,30.300098[ AND (umidity=high)[0.25]
(play=no) AND (umidity=high) AND temperature in [24.24,30.300098[[0.25]
(play=no) AND (umidity=high) AND (wind=weak)[0.25]
(play=no) AND (wind=weak) AND (outlook=sunny)[0.25]
(play=no) AND (wind=weak) AND (umidity=high)[0.25]
(play=yes) AND (outlook=rain) AND (wind=weak)[0.25]
(play=yes) AND temperature in [0.0,6.06[ AND (umidity=normal)[0.25]
(play=yes) AND (umidity=high) AND (wind=weak)[0.25]
(play=yes) AND (umidity=normal) AND temperature in [0.0,6.06[[0.25]
(play=yes) AND (wind=weak) AND (outlook=rain)[0.25]
(play=yes) AND (wind=weak) AND (umidity=high)[0.25]
(outlook=sunny) AND temperature in [24.24,30.300098[ AND (umidity=high) AND (play=no)[0.25]
(outlook=sunny) AND temperature in [24.24,30.300098[ AND (play=no) AND (umidity=high)[0.25]
(outlook=sunny) AND (umidity=high) AND temperature in [24.24,30.300098[ AND (play=no)[0.25]
(outlook=sunny) AND (umidity=high) AND (wind=weak) AND (play=no)[0.25]
(outlook=sunny) AND (umidity=high) AND (play=no) AND temperature in [24.24,30.300098[[0.25]
(outlook=sunny) AND (umidity=high) AND (play=no) AND (wind=weak)[0.25]
(outlook=sunny) AND (wind=weak) AND (umidity=high) AND (play=no)[0.25]
(outlook=sunny) AND (wind=weak) AND (play=no) AND (umidity=high)[0.25]
(outlook=sunny) AND (play=no) AND temperature in [24.24,30.300098[ AND (umidity=high)[0.25]
(outlook=sunny) AND (play=no) AND (umidity=high) AND temperature in [24.24,30.300098[[0.25]
(outlook=sunny) AND (play=no) AND (umidity=high) AND (wind=weak)[0.25]
(outlook=sunny) AND (play=no) AND (wind=weak) AND (umidity=high)[0.25]
temperature in [24.24,30.300098[ AND (outlook=sunny) AND (umidity=high) AND (play=no)[0.25]
temperature in [24.24,30.300098[ AND (outlook=sunny) AND (play=no) AND (umidity=high)[0.25]
temperature in [24.24,30.300098[ AND (umidity=high) AND (outlook=sunny) AND (play=no)[0.25]
temperature in [24.24,30.300098[ AND (umidity=high) AND (play=no) AND (outlook=sunny)[0.25]
temperature in [24.24,30.300098[ AND (play=no) AND (outlook=sunny) AND (umidity=high)[0.25]
temperature in [24.24,30.300098[ AND (play=no) AND (umidity=high) AND (outlook=sunny)[0.25]
(umidity=high) AND (outlook=sunny) AND temperature in [24.24,30.300098[ AND (play=no)[0.25]
(umidity=high) AND (outlook=sunny) AND (wind=weak) AND (play=no)[0.25]
(umidity=high) AND (outlook=sunny) AND (play=no) AND temperature in [24.24,30.300098[[0.25]
(umidity=high) AND (outlook=sunny) AND (play=no) AND (wind=weak)[0.25]
(umidity=high) AND temperature in [24.24,30.300098[ AND (outlook=sunny) AND (play=no)[0.25]
(umidity=high) AND temperature in [24.24,30.300098[ AND (play=no) AND (outlook=sunny)[0.25]
(umidity=high) AND (wind=weak) AND (outlook=sunny) AND (play=no)[0.25]
(umidity=high) AND (wind=weak) AND (play=no) AND (outlook=sunny)[0.25]
(umidity=high) AND (play=no) AND (outlook=sunny) AND temperature in [24.24,30.300098[[0.25]
(umidity=high) AND (play=no) AND (outlook=sunny) AND (wind=weak)[0.25]
(umidity=high) AND (play=no) AND temperature in [24.24,30.300098[ AND (outlook=sunny)[0.25]
(umidity=high) AND (play=no) AND (wind=weak) AND (outlook=sunny)[0.25]
(wind=weak) AND (outlook=sunny) AND (umidity=high) AND (play=no)[0.25]
(wind=weak) AND (outlook=sunny) AND (play=no) AND (umidity=high)[0.25]
(wind=weak) AND (umidity=high) AND (outlook=sunny) AND (play=no)[0.25]
(wind=weak) AND (umidity=high) AND (play=no) AND (outlook=sunny)[0.25]
(wind=weak) AND (play=no) AND (outlook=sunny) AND (umidity=high)[0.25]
(wind=weak) AND (play=no) AND (umidity=high) AND (outlook=sunny)[0.25]
(play=no) AND (outlook=sunny) AND temperature in [24.24,30.300098[ AND (umidity=high)[0.25]
(play=no) AND (outlook=sunny) AND (umidity=high) AND temperature in [24.24,30.300098[[0.25]
(play=no) AND (outlook=sunny) AND (umidity=high) AND (wind=weak)[0.25]
(play=no) AND (outlook=sunny) AND (wind=weak) AND (umidity=high)[0.25]
(play=no) AND temperature in [24.24,30.300098[ AND (outlook=sunny) AND (umidity=high)[0.25]
(play=no) AND temperature in [24.24,30.300098[ AND (umidity=high) AND (outlook=sunny)[0.25]
(play=no) AND (umidity=high) AND (outlook=sunny) AND temperature in [24.24,30.300098[[0.25]
(play=no) AND (umidity=high) AND (outlook=sunny) AND (wind=weak)[0.25]
(play=no) AND (umidity=high) AND temperature in [24.24,30.300098[ AND (outlook=sunny)[0.25]
(play=no) AND (umidity=high) AND (wind=weak) AND (outlook=sunny)[0.25]
(play=no) AND (wind=weak) AND (outlook=sunny) AND (umidity=high)[0.25]
(play=no) AND (wind=weak) AND (umidity=high) AND (outlook=sunny)[0.25]
(outlook=rain)[0.375]
(outlook=sunny)[0.375]
temperature in [0.0,6.06[[0.375]
temperature in [24.24,30.300098[[0.375]
(umidity=normal)[0.375]
(wind=strong)[0.375]
(outlook=sunny) AND (umidity=high)[0.375]
(outlook=sunny) AND (play=no)[0.375]
temperature in [0.0,6.06[ AND (umidity=normal)[0.375]
temperature in [24.24,30.300098[ AND (umidity=high)[0.375]
(umidity=high) AND (outlook=sunny)[0.375]
(umidity=high) AND temperature in [24.24,30.300098[[0.375]
(umidity=high) AND (play=no)[0.375]
(umidity=normal) AND temperature in [0.0,6.06[[0.375]
(wind=weak) AND (play=yes)[0.375]
(play=no) AND (outlook=sunny)[0.375]
(play=no) AND (umidity=high)[0.375]
(play=yes) AND (wind=weak)[0.375]
(outlook=sunny) AND (umidity=high) AND (play=no)[0.375]
(outlook=sunny) AND (play=no) AND (umidity=high)[0.375]
(umidity=high) AND (outlook=sunny) AND (play=no)[0.375]
(umidity=high) AND (play=no) AND (outlook=sunny)[0.375]
(play=no) AND (outlook=sunny) AND (umidity=high)[0.375]
(play=no) AND (umidity=high) AND (outlook=sunny)[0.375]
(play=no)[0.5]
(play=yes)[0.5]
(umidity=high) AND (wind=weak)[0.5]
(wind=weak) AND (umidity=high)[0.5]
(umidity=high)[0.625]
(wind=weak)[0.625]

Emerging patterns

(outlook=rain) AND temperature in [0.0,6.06[[0.25] [Infinity]
(outlook=sunny) AND temperature in [24.24,30.300098[[0.25] [Infinity]
temperature in [0.0,6.06[ AND (outlook=rain)[0.25] [Infinity]
temperature in [0.0,6.06[ AND (wind=strong)[0.25] [Infinity]
temperature in [12.12,18.18[ AND (wind=weak)[0.25] [Infinity]
temperature in [24.24,30.300098[ AND (outlook=sunny)[0.25] [Infinity]
temperature in [24.24,30.300098[ AND (play=no)[0.25] [Infinity]
(wind=strong) AND temperature in [0.0,6.06[[0.25] [Infinity]
(wind=weak) AND temperature in [12.12,18.18[[0.25] [Infinity]
(wind=weak) AND (play=no)[0.25] [Infinity]
(play=no) AND temperature in [24.24,30.300098[[0.25] [Infinity]
(play=no) AND (wind=weak)[0.25] [Infinity]
(outlook=rain) AND temperature in [0.0,6.06[ AND (umidity=normal)[0.25] [Infinity]
(outlook=rain) AND (umidity=normal) AND temperature in [0.0,6.06[[0.25] [Infinity]
(outlook=sunny) AND temperature in [24.24,30.300098[ AND (umidity=high)[0.25] [Infinity]
(outlook=sunny) AND temperature in [24.24,30.300098[ AND (play=no)[0.25] [Infinity]
(outlook=sunny) AND (umidity=high) AND temperature in [24.24,30.300098[[0.25] [Infinity]
(outlook=sunny) AND (umidity=high) AND (wind=weak)[0.25] [Infinity]
(outlook=sunny) AND (wind=weak) AND (umidity=high)[0.25] [Infinity]
(outlook=sunny) AND (wind=weak) AND (play=no)[0.25] [Infinity]
(outlook=sunny) AND (play=no) AND temperature in [24.24,30.300098[[0.25] [Infinity]
(outlook=sunny) AND (play=no) AND (wind=weak)[0.25] [Infinity]
temperature in [0.0,6.06[ AND (outlook=rain) AND (umidity=normal)[0.25] [Infinity]
temperature in [0.0,6.06[ AND (umidity=normal) AND (outlook=rain)[0.25] [Infinity]
temperature in [0.0,6.06[ AND (umidity=normal) AND (wind=strong)[0.25] [Infinity]
temperature in [0.0,6.06[ AND (wind=strong) AND (umidity=normal)[0.25] [Infinity]
temperature in [12.12,18.18[ AND (umidity=high) AND (wind=weak)[0.25] [Infinity]
temperature in [12.12,18.18[ AND (wind=weak) AND (umidity=high)[0.25] [Infinity]
temperature in [24.24,30.300098[ AND (outlook=sunny) AND (umidity=high)[0.25] [Infinity]
temperature in [24.24,30.300098[ AND (outlook=sunny) AND (play=no)[0.25] [Infinity]
temperature in [24.24,30.300098[ AND (umidity=high) AND (outlook=sunny)[0.25] [Infinity]
temperature in [24.24,30.300098[ AND (umidity=high) AND (wind=weak)[0.25] [Infinity]
temperature in [24.24,30.300098[ AND (umidity=high) AND (play=no)[0.25] [Infinity]
temperature in [24.24,30.300098[ AND (wind=weak) AND (umidity=high)[0.25] [Infinity]
temperature in [24.24,30.300098[ AND (play=no) AND (outlook=sunny)[0.25] [Infinity]
temperature in [24.24,30.300098[ AND (play=no) AND (umidity=high)[0.25] [Infinity]
(umidity=high) AND (outlook=sunny) AND temperature in [24.24,30.300098[[0.25] [Infinity]
(umidity=high) AND (outlook=sunny) AND (wind=weak)[0.25] [Infinity]
(umidity=high) AND temperature in [12.12,18.18[ AND (wind=weak)[0.25] [Infinity]
(umidity=high) AND temperature in [24.24,30.300098[ AND (outlook=sunny)[0.25] [Infinity]
(umidity=high) AND temperature in [24.24,30.300098[ AND (wind=weak)[0.25] [Infinity]
(umidity=high) AND temperature in [24.24,30.300098[ AND (play=no)[0.25] [Infinity]
(umidity=high) AND (wind=weak) AND (outlook=sunny)[0.25] [Infinity]
(umidity=high) AND (wind=weak) AND temperature in [12.12,18.18[[0.25] [Infinity]
(umidity=high) AND (wind=weak) AND temperature in [24.24,30.300098[[0.25] [Infinity]
(umidity=high) AND (wind=weak) AND (play=no)[0.25] [Infinity]
(umidity=high) AND (wind=weak) AND (play=yes)[0.25] [Infinity]
(umidity=high) AND (play=no) AND temperature in [24.24,30.300098[[0.25] [Infinity]
(umidity=high) AND (play=no) AND (wind=weak)[0.25] [Infinity]
(umidity=high) AND (play=yes) AND (wind=weak)[0.25] [Infinity]
(umidity=normal) AND (outlook=rain) AND temperature in [0.0,6.06[[0.25] [Infinity]
(umidity=normal) AND temperature in [0.0,6.06[ AND (outlook=rain)[0.25] [Infinity]
(umidity=normal) AND temperature in [0.0,6.06[ AND (wind=strong)[0.25] [Infinity]
(umidity=normal) AND (wind=strong) AND temperature in [0.0,6.06[[0.25] [Infinity]
(wind=strong) AND temperature in [0.0,6.06[ AND (umidity=normal)[0.25] [Infinity]
(wind=strong) AND (umidity=normal) AND temperature in [0.0,6.06[[0.25] [Infinity]
(wind=weak) AND (outlook=sunny) AND (umidity=high)[0.25] [Infinity]
(wind=weak) AND (outlook=sunny) AND (play=no)[0.25] [Infinity]
(wind=weak) AND temperature in [12.12,18.18[ AND (umidity=high)[0.25] [Infinity]
(wind=weak) AND temperature in [24.24,30.300098[ AND (umidity=high)[0.25] [Infinity]
(wind=weak) AND (umidity=high) AND (outlook=sunny)[0.25] [Infinity]
(wind=weak) AND (umidity=high) AND temperature in [12.12,18.18[[0.25] [Infinity]
(wind=weak) AND (umidity=high) AND temperature in [24.24,30.300098[[0.25] [Infinity]
(wind=weak) AND (umidity=high) AND (play=no)[0.25] [Infinity]
(wind=weak) AND (umidity=high) AND (play=yes)[0.25] [Infinity]
(wind=weak) AND (play=no) AND (outlook=sunny)[0.25] [Infinity]
(wind=weak) AND (play=no) AND (umidity=high)[0.25] [Infinity]
(wind=weak) AND (play=yes) AND (umidity=high)[0.25] [Infinity]
(play=no) AND (outlook=sunny) AND temperature in [24.24,30.300098[[0.25] [Infinity]
(play=no) AND (outlook=sunny) AND (wind=weak)[0.25] [Infinity]
(play=no) AND temperature in [24.24,30.300098[ AND (outlook=sunny)[0.25] [Infinity]
(play=no) AND temperature in [24.24,30.300098[ AND (umidity=high)[0.25] [Infinity]
(play=no) AND (umidity=high) AND temperature in [24.24,30.300098[[0.25] [Infinity]
(play=no) AND (umidity=high) AND (wind=weak)[0.25] [Infinity]
(play=no) AND (wind=weak) AND (outlook=sunny)[0.25] [Infinity]
(play=no) AND (wind=weak) AND (umidity=high)[0.25] [Infinity]
(play=yes) AND (umidity=high) AND (wind=weak)[0.25] [Infinity]
(play=yes) AND (wind=weak) AND (umidity=high)[0.25] [Infinity]
(outlook=sunny) AND temperature in [24.24,30.300098[ AND (umidity=high) AND (play=no)[0.25] [Infinity]
(outlook=sunny) AND temperature in [24.24,30.300098[ AND (play=no) AND (umidity=high)[0.25] [Infinity]
(outlook=sunny) AND (umidity=high) AND temperature in [24.24,30.300098[ AND (play=no)[0.25] [Infinity]
(outlook=sunny) AND (umidity=high) AND (wind=weak) AND (play=no)[0.25] [Infinity]
(outlook=sunny) AND (umidity=high) AND (play=no) AND temperature in [24.24,30.300098[[0.25] [Infinity]
(outlook=sunny) AND (umidity=high) AND (play=no) AND (wind=weak)[0.25] [Infinity]
(outlook=sunny) AND (wind=weak) AND (umidity=high) AND (play=no)[0.25] [Infinity]
(outlook=sunny) AND (wind=weak) AND (play=no) AND (umidity=high)[0.25] [Infinity]
(outlook=sunny) AND (play=no) AND temperature in [24.24,30.300098[ AND (umidity=high)[0.25] [Infinity]
(outlook=sunny) AND (play=no) AND (umidity=high) AND temperature in [24.24,30.300098[[0.25] [Infinity]
(outlook=sunny) AND (play=no) AND (umidity=high) AND (wind=weak)[0.25] [Infinity]
(outlook=sunny) AND (play=no) AND (wind=weak) AND (umidity=high)[0.25] [Infinity]
temperature in [24.24,30.300098[ AND (outlook=sunny) AND (umidity=high) AND (play=no)[0.25] [Infinity]
temperature in [24.24,30.300098[ AND (outlook=sunny) AND (play=no) AND (umidity=high)[0.25] [Infinity]
temperature in [24.24,30.300098[ AND (umidity=high) AND (outlook=sunny) AND (play=no)[0.25] [Infinity]
temperature in [24.24,30.300098[ AND (umidity=high) AND (play=no) AND (outlook=sunny)[0.25] [Infinity]
temperature in [24.24,30.300098[ AND (play=no) AND (outlook=sunny) AND (umidity=high)[0.25] [Infinity]
temperature in [24.24,30.300098[ AND (play=no) AND (umidity=high) AND (outlook=sunny)[0.25] [Infinity]
(umidity=high) AND (outlook=sunny) AND temperature in [24.24,30.300098[ AND (play=no)[0.25] [Infinity]
(umidity=high) AND (outlook=sunny) AND (wind=weak) AND (play=no)[0.25] [Infinity]
(umidity=high) AND (outlook=sunny) AND (play=no) AND temperature in [24.24,30.300098[[0.25] [Infinity]
(umidity=high) AND (outlook=sunny) AND (play=no) AND (wind=weak)[0.25] [Infinity]
(umidity=high) AND temperature in [24.24,30.300098[ AND (outlook=sunny) AND (play=no)[0.25] [Infinity]
(umidity=high) AND temperature in [24.24,30.300098[ AND (play=no) AND (outlook=sunny)[0.25] [Infinity]
(umidity=high) AND (wind=weak) AND (outlook=sunny) AND (play=no)[0.25] [Infinity]
(umidity=high) AND (wind=weak) AND (play=no) AND (outlook=sunny)[0.25] [Infinity]
(umidity=high) AND (play=no) AND (outlook=sunny) AND temperature in [24.24,30.300098[[0.25] [Infinity]
(umidity=high) AND (play=no) AND (outlook=sunny) AND (wind=weak)[0.25] [Infinity]
(umidity=high) AND (play=no) AND temperature in [24.24,30.300098[ AND (outlook=sunny)[0.25] [Infinity]
(umidity=high) AND (play=no) AND (wind=weak) AND (outlook=sunny)[0.25] [Infinity]
(wind=weak) AND (outlook=sunny) AND (umidity=high) AND (play=no)[0.25] [Infinity]
(wind=weak) AND (outlook=sunny) AND (play=no) AND (umidity=high)[0.25] [Infinity]
(wind=weak) AND (umidity=high) AND (outlook=sunny) AND (play=no)[0.25] [Infinity]
(wind=weak) AND (umidity=high) AND (play=no) AND (outlook=sunny)[0.25] [Infinity]
(wind=weak) AND (play=no) AND (outlook=sunny) AND (umidity=high)[0.25] [Infinity]
(wind=weak) AND (play=no) AND (umidity=high) AND (outlook=sunny)[0.25] [Infinity]
(play=no) AND (outlook=sunny) AND temperature in [24.24,30.300098[ AND (umidity=high)[0.25] [Infinity]
(play=no) AND (outlook=sunny) AND (umidity=high) AND temperature in [24.24,30.300098[[0.25] [Infinity]
(play=no) AND (outlook=sunny) AND (umidity=high) AND (wind=weak)[0.25] [Infinity]
(play=no) AND (outlook=sunny) AND (wind=weak) AND (umidity=high)[0.25] [Infinity]
(play=no) AND temperature in [24.24,30.300098[ AND (outlook=sunny) AND (umidity=high)[0.25] [Infinity]
(play=no) AND temperature in [24.24,30.300098[ AND (umidity=high) AND (outlook=sunny)[0.25] [Infinity]
(play=no) AND (umidity=high) AND (outlook=sunny) AND temperature in [24.24,30.300098[[0.25] [Infinity]
(play=no) AND (umidity=high) AND (outlook=sunny) AND (wind=weak)[0.25] [Infinity]
(play=no) AND (umidity=high) AND temperature in [24.24,30.300098[ AND (outlook=sunny)[0.25] [Infinity]
(play=no) AND (umidity=high) AND (wind=weak) AND (outlook=sunny)[0.25] [Infinity]
(play=no) AND (wind=weak) AND (outlook=sunny) AND (umidity=high)[0.25] [Infinity]
(play=no) AND (wind=weak) AND (umidity=high) AND (outlook=sunny)[0.25] [Infinity]
(outlook=sunny) AND (umidity=high)[0.375] [Infinity]
(outlook=sunny) AND (play=no)[0.375] [Infinity]
temperature in [24.24,30.300098[ AND (umidity=high)[0.375] [Infinity]
(umidity=high) AND (outlook=sunny)[0.375] [Infinity]
(umidity=high) AND temperature in [24.24,30.300098[[0.375] [Infinity]
(play=no) AND (outlook=sunny)[0.375] [Infinity]
(outlook=sunny) AND (umidity=high) AND (play=no)[0.375] [Infinity]
(outlook=sunny) AND (play=no) AND (umidity=high)[0.375] [Infinity]
(umidity=high) AND (outlook=sunny) AND (play=no)[0.375] [Infinity]
(umidity=high) AND (play=no) AND (outlook=sunny)[0.375] [Infinity]
(play=no) AND (outlook=sunny) AND (umidity=high)[0.375] [Infinity]
(play=no) AND (umidity=high) AND (outlook=sunny)[0.375] [Infinity]
(umidity=high) AND (wind=weak)[0.5] [Infinity]
(wind=weak) AND (umidity=high)[0.5] [Infinity]

Caso Test 2:

Opzione:Nuova scoperta

Valore di minimo supporto:0.9

Valore minimo di Grow Rate:6

Tabella Target:playtennisTarget

Tabella Background:playtennisBackground

Risultati:

Frequent patterns

Emerging patterns
data.EmptySetException

Caso Test 3:

Opzione:Risultati in archivio

Valore di minimo supporto:0.5

Valore minimo di Grow Rate:0.5

Tabella Target:playtennisTarget

Tabella Background:playtennisBackground

Risultati:

Frequent patterns
java.io.FileNotFoundException: FP_playtennis_minSup0.5.dat (Impossibile trovare il file specificato)

La computazione deve essere già stata effettuata in precedenza, altrimenti non viene trovata, come in questo caso.
