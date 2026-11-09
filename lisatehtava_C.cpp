#include <stdio.h>
#include <memory.h>

typedef struct {
        char sn[100];
        char en[100];
        char puolue[10];
        int aanimaara;
} EHDOKAS;

// Tee funktio, joka poistaa annetun ehdokkaan etunimest�
// kaikki muut kirjaimet paitsi ensimm�isen
void poistaEtunimi(EHDOKAS *pEhdokas)
{
    pEhdokas->en[1] = '.';
    pEhdokas->en[2] = '\0';
}

void main()
{
    EHDOKAS ehdokkaat[2000]; // taulukko kaikkia ehdokkaita varten
    memset(ehdokkaat, 0, 2000 * sizeof(EHDOKAS)); // tyhjennet��n koko taulukko

    FILE *fp = fopen("c:\\tmp\\ehdokkaat2008.txt", "r"); 

    char rivi[256];

    EHDOKAS tyhja = {"","","",-1};
    EHDOKAS *pParas = &tyhja;

    int i = 0;
    while (fgets(rivi, 255, fp) != 0)
    {
        // poimitaan tiedot rivilt�
        sscanf(rivi, "%s %s %s %d", ehdokkaat[i].sn, ehdokkaat[i].en,
            ehdokkaat[i].puolue, &(ehdokkaat[i].aanimaara));

        poistaEtunimi(&ehdokkaat[i]);
        if (ehdokkaat[i].aanimaara > pParas->aanimaara)
        {
            //parasEhdokas = ehdokkaat[i];
            pParas = &ehdokkaat[i];
        }
        i++;
        //printf("%s", rivi); // testataan, ett� tiedoston luku toimii 
    }
    if (pParas != 0)
    {
        printf("%s %s %s %d\n", pParas->sn, pParas->en,
            pParas->puolue, pParas->aanimaara);
    }
    //printf("%s %s %s %d\n", pParas->sn, pParas->en,
    //    pParas->puolue, pParas->aanimaara);
    fclose(fp);

}