package com.olivia.nyu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//@arr1910 @nadjabreton Pero pues sí él representa esa tradición de Morena de los \"mapaches", la tranza y la corrupción... ¿De qué se queja?
public class RegexDemo {

    public static void main(String[] args) {

        String content = "<user1>1187567834437697536</user1>\n" +
                "<tweet1>@arr1910 @nadjabreton Pero pues sí él representa esa tradición de Morena de los \"mapaches\", la tranza y la corrupción... ¿De qué se queja?</tweet1>\n" +
                "<tweet2>@ponchoherrera @azucenau Cierto, pero está vez es evidente que las y los policías no tuvieron una responsabilidad d… https://t.co/iD249bSCcv</tweet2>\n" +
                "<tweet3>@72Lindero @azucenau Tenemos un Narcopresidente, una inepta jefa de gobierno,cuyos funcionarios más cercanos proteg… https://t.co/UEYiilComy</tweet3>\n" +
                "<tweet4>@qtf @drjoseoscarv El daños que pudo haber causado un artículo como ese, no justifica la popularidad de quiénes buscaban impulsarlo.</tweet4>\n" +
                "<tweet5>@notibomba @aran_tirado @lopezobrador_ Pues esto del socialismo tembeleque de López Obrador no veo que haga crecer… https://t.co/s4iALgQRmb</tweet5>\n" +
                "<tweet6>@guruchuirer @abarrotesgab Ahora sí López Obrador será el único en robar el presupuesto completo.</tweet6>\n" +
                "<tweet7>@faycastel Gracias colega por tu valiosa aportación, sin embargo, la duda es si es legal venderla fría o no #sarcasmo</tweet7>\n" +
                "<tweet8>@kdartigues Andrés Manuel López Obrador sin el narcotráfico</tweet8>\n" +
                "<tweet9>@patriciajaniot México no, el presidente López Obrador, que es su socio y los protege y solapa.</tweet9>\n" +
                "<tweet10>@Foro_TV El Presidente Trump, quien lleva años en la Casa Blanca, había pensado que el apelativo \"Nuevo\" México, ha… https://t.co/CTKVKbz7Ef</tweet10>\n" +
                "<tweet11>@Pajaropolitico @jenarovillamil Cuántos jueces con apellido Padierna, hasta se me hace que son una especie de corporación, ¿no?</tweet11>\n" +
                "<user2>134711882</user2>\n" +
                "<tweet1>Unf****in BELIEVABLE. We have officially reentered the Dark Ages. #HarveyWeinstein #HardToSee https://t.co/AnQFbGw7K2</tweet1>\n" +
                "<tweet2>@NouveauBougee @OhNoSheTwitnt It’s called white male privilege. But it doesn’t really exist. Just like climate chan… https://t.co/uQHBEUUUST</tweet2>\n" +
                "<tweet3>#TruthExposed https://t.co/yYrxqkDEwS</tweet3>\n" +
                "<tweet4>@lydiamarieguti1 @larzilar @JXESAID Who’s buying them? The deplorables maybe..? You know the ones who want us to go… https://t.co/JJ971ULGhe</tweet4>\n" +
                "<tweet5>@guelphgirlchris My ex who  was also a sociopath &amp; pathological liar was also  from the area. Explains a lot .</tweet5>\n" +
                "<tweet6>If I sat around and listened to all the advice the ‘experts’ gave me - ‘you don’t have enough $$$, you can’t do it,… https://t.co/S6iCV1IpHN</tweet6>\n" +
                "<tweet7>‘I live my live with pain, passion &amp; purpose’~ Elijah Cummings. Tear gassed, beaten ..RIP , Warrior  you inspired g… https://t.co/jAjIRzrLvc</tweet7>\n" +
                "<tweet8>#womeninspire https://t.co/1Q463m3NR0</tweet8>\n" +
                "<tweet9>@hellolanemoore Preach, sister, preach. Having good friends, a clean conscience, goals, ambitions to wake up to eve… https://t.co/PxlmF1oM3D</tweet9>\n" +
                "<tweet10>#WomenLeadTheWay . Preach sister, preach. Go Jameela \uD83D\uDE4C\uD83D\uDC4D\uD83C\uDFFC\uD83D\uDC83 https://t.co/m2ddRoZeLA</tweet10>\n" +
                "<tweet11>@lynndelaney @ProfaneFeminist Umm that’s RIGHT, be grateful you’re ALIVE today and you don’t need a man to validate… https://t.co/wKYapjqiiI</tweet11>\n" +
                "<tweet12>#womeninspire https://t.co/N3yy2ir1NK</tweet12>\n" +
                "<tweet13>#womeninspire https://t.co/AZnhOMyaZe</tweet13>\n" +
                "<tweet14>Just saying\uD83D\uDC8B. #beware #elzazagreda #femalefilmmaker #femalefilmmakerfriday #awardwinner @elzazagreda #proudproducer… https://t.co/IVsIg5MURi</tweet14>\n" +
                "<tweet15>Just saying\uD83D\uDC8B. #beware #elzazagreda #femalefilmmaker #femalefilmmakerfriday #awardwinner @elzazagreda #proudproducer… https://t.co/CHFmcZt6vP</tweet15>\n" +
                "<tweet16>#WomanCrushWednesday https://t.co/YTgqpywhZE</tweet16>\n" +
                "<tweet17>@HillaryClinton @realDonaldTrump Pretty please \uD83D\uDE4F. Yes Hillary \uD83C\uDFC3\u200D♀️!!! \uD83D\uDE4C\uD83D\uDE4C\uD83D\uDE4C\uD83D\uDE4C\uD83D\uDE4C\uD83D\uDE4C\uD83D\uDE4C\uD83D\uDE4C\uD83D\uDE4C\uD83D\uDE4C\uD83D\uDE4C\uD83D\uDE4C</tweet17>\n" +
                "<tweet18>#WomenChangingTheWorld #womeninspire #KurdsBetrayedByTrump #shameful https://t.co/mfw6A7mH21</tweet18>\n" +
                "<tweet19>@rhorseranch_joy Please God, please. \uD83D\uDE4F#GutsyWomen #Hillary #imstillwithher</tweet19>\n" +
                "<tweet20>#womeninspire #RIPDiahannCarroll #legend https://t.co/WfxpEAoWgY</tweet20>\n" +
                "<tweet21>Damn right she has a life— THEN &amp; Now. And we were robbed of a President— who acts like a President. And she won’t… https://t.co/vtnO3Qnv6o</tweet21>\n" +
                "<tweet22>You can’t keep a good woman down. #ImStillWithHer https://t.co/CsC3BENXqm</tweet22>\n" +
                "<tweet23>@NYMag @onesarahjones Wow, can we say misogyny is alive and well? Thanks, point taken Sara. \uD83D\uDC4D\uD83C\uDFFC</tweet23>\n" +
                "<tweet24>#womeninspire https://t.co/MNfNIiLNc8</tweet24>\n" +
                "<tweet25>@Newsweek Getting my burka with the open eye slits on now. Excellent . \uD83D\uDE4F\uD83D\uDC4D\uD83C\uDFFC</tweet25>\n" +
                "<tweet26>London got me like...... \uD83C\uDDEC\uD83C\uDDE7 #happyblonde #elzazagreda #awardwinner #femalefilmmaker #londonista  #londoncalling… https://t.co/dX3GHx5rpp</tweet26>\n" +
                "<tweet27>#womeninspire #badasswomen https://t.co/8trxwpRbj4</tweet27>\n" +
                "<tweet28>#ImStillWithHer #IllegitimatePresident #shameful https://t.co/8KjpeEt4st</tweet28>\n" +
                "<tweet29>#womeninspire #ChristineBlaseyFord https://t.co/qAIvImm7pj</tweet29>\n" +
                "<tweet30>#womeninspire @ava https://t.co/FSe7dHxh9I</tweet30>\n" +
                "<tweet31>Just goes to show age is just a number.  I want to look like that NOW. #womeninspire #womeninfilm https://t.co/hVMqHgYN3Z</tweet31>\n" +
                "<tweet32>@KennedyJReeves That’s my girl \uD83D\uDC4D\uD83C\uDFFC\uD83D\uDCAA\uD83C\uDFFC#girlpower #womeninspire</tweet32>\n" +
                "<tweet33>The 58th million reason #iloveny . It’s the only city where 600 people gather in #bryantpark and collectively do yo… https://t.co/6bmcis8gKY</tweet33>\n" +
                "<tweet34>@Sameddy80454656 @NYMag Only when she slaps his arm to say ‘don’t touch me.’</tweet34>\n" +
                "<tweet35>@exoticgamora and while at it, let’s stone them to death and throw acid in their faces, that will shut us up for sure \uD83D\uDC4D\uD83C\uDFFC</tweet35>\n" +
                "<tweet36>And I think we should start stoning them too. https://t.co/yHFEMH9WKD</tweet36>\n" +
                "<tweet37>Back, white , yellow, ... Women Inspire. This just became my daily affirmation. All hail the Queen . \uD83D\uDE4F… https://t.co/EtSoihiJcP</tweet37>\n" +
                "<tweet38>My back to work/ school outfit. Sophia Loren meets Hemingway \uD83D\uDE0A .#elzazagreda #femalefilmmaker… https://t.co/sqcr1ni1NJ</tweet38>\n" +
                "<tweet39>West Coast, East Coast.. LA, NYC, Miami, in an ER in the city..\uD83D\uDE0A ( shout out to Nurse DRAGO, you were the best ! )… https://t.co/SKuCezeX47</tweet39>\n" +
                "<tweet40>I’m still with her. https://t.co/CQaHUM5inV</tweet40>\n" +
                "<tweet41>@JoyceWhiteVance Our system is BROKEN. The constitution/ our forefathers were  not infallible. We need to find solu… https://t.co/bTFjLpMhZN</tweet41>\n" +
                "<tweet42>@ShelbyKStewart It was deteriorating at DAY 1. So over. Every day, every hour he gets away with it. It’s s banana r… https://t.co/NAE73YsEeN</tweet42>\n" +
                "<tweet43>Wait, WHAT do you mean I won for Best Original Screenplay in London for my wildly popular film @elzazagreda ?\uD83E\uDD37\u200D♀️\uD83D\uDC83\uD83D\uDE0A… https://t.co/j5eHIRyUsq</tweet43>\n" +
                "<tweet44>@Frances_Fisher @yashar @marwilliamson I actually prefer the 1st tweet.</tweet44>\n" +
                "<tweet45>#womeninspire https://t.co/mAyY1jy6hF</tweet45>\n" +
                "<tweet46>Wait, does the 6 train stop here, I’m confused ? .. is this Staten Island or something, where’s midtown?… https://t.co/vMxVXNa6IF</tweet46>\n" +
                "<tweet47>If you want to find a serial killer or pedophile, tinder is the way to go. \uD83D\uDC4D\uD83C\uDFFC. #onlinedating #JustSaying #JustSayNo https://t.co/u8VcZTzew0</tweet47>\n" +
                "<tweet48>Ok, bags packed, ready to go.\uD83D\uDCAA\uD83C\uDFFC.....got a film ( and play) ready to roll. #yourestyourust #elzazagreda… https://t.co/n0DrASrlml</tweet48>\n" +
                "<tweet49>Be the captain of your own ship. #elzazagreda #femalefilmmaker #awardwinner @elzazagreda #femalefilmmakerfriday… https://t.co/SYaFWhLnBy</tweet49>\n" +
                "<tweet50>Bad Ass \uD83D\uDCAA\uD83C\uDFFC#RBG #RuthBaderGinsburg https://t.co/sqbGYF0pVX</tweet50>\n" +
                "<tweet51>@SarahKSilverman Sounds a lot like my ex husband.</tweet51>\n" +
                "<tweet52>Women inspire. #justdoit https://t.co/lEwfcUAV0S</tweet52>\n" +
                "<tweet53>Rest In Peace you Beautiful Soul. \uD83D\uDE4F Tortured, misunderstood, abandoned, motherless, a child bride, abused ... yet y… https://t.co/2e8NgRdENw</tweet53>\n" +
                "<tweet54>\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A https://t.co/WSftLi5eTX</tweet54>\n" +
                "<tweet55>She said YES. #womeninspire https://t.co/uIm12R6UeN</tweet55>\n" +
                "<tweet56>Not sure you can call it work when you get to do what you love ❤️ with people you ❤️ , the people you love come and… https://t.co/doOWEK14V9</tweet56>\n" +
                "<tweet57>@yank1tig @HuffPost And they Made America Great Again!! #thankyou  @mPinoe #WomensChampion #womensinspire #FIFAWWC</tweet57>\n" +
                "<tweet58>#WomensWorldCup2019 #womeninspire https://t.co/frgzIpRUYh</tweet58>\n" +
                "<tweet59>#womeninspire https://t.co/zmOIZlgj3W</tweet59>\n" +
                "<tweet60>I miss this. Appreciate the moments .❤️❤️❤️ #thelittlethings #restrelaxrecharge #candid #goodfriendsgoodtimes… https://t.co/0ISZUgsTZu</tweet60>\n" +
                "<tweet61>#womeninspire #WomensWorldCup https://t.co/piXeu0zZ5B</tweet61>\n" +
                "<tweet62>The necklace says it all. ‘When you love what you do.” #jadore #dior #elzazagreda #awardwinning #femalefilmmaker… https://t.co/PF5IyRELQm</tweet62>\n" +
                "<tweet63>#womeninspire #hero #rbg https://t.co/TvczgUCFxK</tweet63>\n" +
                "<tweet64>@StopTrump2020 Total Eclipse of the Heart</tweet64>\n" +
                "<tweet65>My God. What have we become? \uD83E\uDD37\u200D♀️\uD83D\uDE14\uD83D\uDE4C #America https://t.co/Cfk3mBNbZz</tweet65>\n" +
                "<tweet66>After 1500 submissions including  48 from talent / agent submissions, with only 5 roles .. so thrilled to be workin… https://t.co/lJpYDzQZy8</tweet66>\n" +
                "<tweet67>\uD83D\uDCAA\uD83C\uDFFC\uD83D\uDCAA\uD83C\uDFFC\uD83D\uDCAA\uD83C\uDFFC\uD83D\uDCAA\uD83C\uDFFC\uD83D\uDCAA\uD83C\uDFFC\uD83D\uDCAA\uD83C\uDFFC https://t.co/vxuATt77TL</tweet67>\n" +
                "<tweet68>#womeninspire https://t.co/6N6PPlAQ9H</tweet68>\n" +
                "<tweet69>#womeninspire https://t.co/JAYWnAQvLQ</tweet69>\n" +
                "<tweet70>No excusar... I was told the 9 train stop here? I’ve got a play I just got cast in in #NYC &amp; Lyddie needs to head t… https://t.co/dlTv4iNzov</tweet70>\n" +
                "<tweet71>#damnright #ImStillWithHer @HillaryClinton @HillaryWarnedUs https://t.co/McD8omj8l2</tweet71>\n" +
                "<tweet72>Excuse me.. does the #6 train stop here? #elzazagreda #femalefilmmaker #straphanger #majorca #heavenisaplaceonearth… https://t.co/dFjVGPXSho</tweet72>\n" +
                "<tweet73>#womeninspire https://t.co/aecgk1dWJw</tweet73>\n" +
                "<tweet74>@kgoss1128 @crymeariver6666 @GovMikeHuckabee @realDonaldTrump @PressSec @POTUS I mean they weren’t REAL COMPLIMENTS… https://t.co/mI7LbK2nFX</tweet74>\n" +
                "<tweet75>#womeninspire #ElizabethWarren \uD83D\uDC4D\uD83C\uDFFC #preach https://t.co/dftZM1trjC</tweet75>\n" +
                "<tweet76>Thank you to the beautiful Spanish senorita  cancotahotel for making my stay in Majorca so spectacular. An… https://t.co/uZ3ASiR6B2</tweet76>\n" +
                "<tweet77>Move over, John Travolta.. you ain’t the only one rockin that white pantsuit from Saturday Night Fever. I’m ready f… https://t.co/stJx9gpAbU</tweet77>\n" +
                "<tweet78>Move over, John Travolta.. you ain’t the only one rockin that white pantsuit from Saturday Night Fever. I’m ready f… https://t.co/ZhGPZspOeN</tweet78>\n" +
                "<tweet79>@johnpavlovitz It was amazing to be in Majorca on a yoga retreat and NOT ONCE have to see or listen to the buffoon… https://t.co/K8KI7f7c3d</tweet79>\n" +
                "<tweet80>@Courage20192112 @homemadeguitars @zunderwhelmed @nytimes The day after Madame President lost I immediately cancell… https://t.co/8OmBV8lXkO</tweet80>\n" +
                "<tweet81>#womeninspire https://t.co/XWvE24ReYh</tweet81>\n" +
                "<tweet82>I’m still with her . #Hillary2020 https://t.co/NfASvdZwAu</tweet82>\n" +
                "<tweet83>I entered the @BurnThisBway Lottery for $39 tickets on @TodayTix! Tap here to enter: https://t.co/ujYeAd7YbO #fingerscrossed</tweet83>\n" +
                "<tweet84>#truth https://t.co/yieSqzx4U2</tweet84>\n" +
                "<tweet85>#womeninspire \uD83D\uDE4C\uD83D\uDE4C\uD83D\uDE4C https://t.co/p9Q7oBUTYN</tweet85>\n" +
                "<tweet86>Yet again he goes unpunished. Why do we even have a Congress? \uD83E\uDD37\u200D♀️ #disgusting #DoSomething https://t.co/JNWtvQAJ9d</tweet86>\n" +
                "<tweet87>#womeninspire https://t.co/MV8PiH8NVY</tweet87>\n" +
                "<tweet88>‘ I eat NO for breakfast.’ ~ Kamala Harris \uD83D\uDCAA\uD83C\uDFFC. Alabama, Georgia, Missouri, where a rapist has more rights than a wo… https://t.co/bIi76pmcsN</tweet88>\n" +
                "<tweet89>@fierysadness @AlexArg81560421 Wait ART imitating life in a Woody Allen film? Unbelievable. Nah, he’s not guilty....</tweet89>\n" +
                "<tweet90>#WomenRightsAreHumanRights https://t.co/RoXZv68lPs</tweet90>\n" +
                "<tweet91>#TruthHurts #womeninspire https://t.co/EDNe1NuGnZ</tweet91>\n" +
                "<tweet92>#womeninspire https://t.co/krA2vfuIla</tweet92>\n" +
                "<tweet93>Start me up. You make a grown man cry. #ageisjustanumber https://t.co/6xvUw5Azg5</tweet93>\n" +
                "<tweet94>@Rosie Well c’mon now.. she can say ‘HI’ fluently in 8 languages and all.. that must count for something? \uD83D\uDE0A\uD83E\uDD37\u200D♀️\uD83D\uDE33</tweet94>\n" +
                "<tweet95>#truth https://t.co/4k5WwlLWTF</tweet95>\n" +
                "<tweet96>Shocked and Surprised. ❤️\uD83D\uDC4D\uD83C\uDFFC #not #iloveny https://t.co/DVz7aXAhlf</tweet96>\n" +
                "<tweet97>@girlsreallyrule @ananavarro @MeghanMcCain She only confirms the narrative that patriarchy is not only alive and we… https://t.co/f3JYeGpXpA</tweet97>\n" +
                "<tweet98>#womeninspire https://t.co/FjdUSjBof1</tweet98>\n" +
                "<tweet99>#womeninspire https://t.co/yKUenXxiqr</tweet99>\n" +
                "<tweet100>Always brilliantly spot on. Not only would you make a fierce  president,  but we’d laugh our asses every day, in a… https://t.co/GqPdPPRIFU</tweet100>\n" +
                "<tweet101>#womeninspire https://t.co/pNLIQdGUgG</tweet101>\n" +
                "<tweet102>‘You have to believe. You have to be hopeful. You have to be optimistic.’~ The Great Senator John Lewis. If this li… https://t.co/0RIjzQRZUc</tweet102>\n" +
                "<tweet103>@KennedyJReeves You GOT THIS! \uD83D\uDC4D\uD83C\uDFFCthink Norma Rae.....</tweet103>\n" +
                "<tweet104>@dhannah412 @hawkeye1x @chrislhayes But he gets away with it. Every Single Day. STOP SHOWING IT . #EnoughSaid</tweet104>\n" +
                "<tweet105>@joaninDC61 @CyrusMMcQueen @MeghanMcCain You absolutely nailed it. As Gloria Steinem gloriously notes ‘we live in a… https://t.co/jRxTKxgOcT</tweet105>\n" +
                "<tweet106>#womeninspire https://t.co/Hbw93nJhar</tweet106>\n" +
                "<tweet107>It might not be the #metgala this year..but with a little drive, vision &amp; ambition, a girl can dream. #elzazagreda… https://t.co/1qefgPT0Gz</tweet107>\n" +
                "<tweet108>#womeninspire https://t.co/HWLR78DYwX</tweet108>\n" +
                "<tweet109>#womeninspire https://t.co/tivSavYTlk</tweet109>\n" +
                "<tweet110>Kosovo War Rape Victim Urges US Congress to Seek Justice https://t.co/bMXTs5deOj</tweet110>\n" +
                "<tweet111>#womeninspire https://t.co/AhZxXoN4Bl</tweet111>\n" +
                "<tweet112>I might not be Amal Clooney..but so loud and proud to lend my voice, my heart and soul to these amazing heroes who… https://t.co/5L6BPiD2du</tweet112>\n" +
                "<tweet113>SO loud &amp; proud of the #heroes .  Kosovo  War Rape Victim Urges US Congress to Seek Justice https://t.co/bMXTs5deOj\n" +
                "#womeninspire #justice</tweet113>\n" +
                "<tweet114>Call to action. NEVER FORGET. 20,000 women &amp; men raped. 1,600 still missing, 13,950 killed #humanityfirst… https://t.co/L9cuKnY9PM</tweet114>\n" +
                "<tweet115>Nope, NOT having it. \uD83E\uDD1AWomen’s bodies are NOT commodities to be used as a weapon of war. Words MATTER. Rape, genocid… https://t.co/qfWfau2UNd</tweet115>\n" +
                "<tweet116>Story of my life . #truth https://t.co/GCCK5TrWZx</tweet116>\n" +
                "<tweet117>That’s RIGHT WASHINGTON!! here we come! These badasses can’t WAIT to take the Capital by Storm this Tuesday to prot… https://t.co/Z76zoNNx5x</tweet117>\n" +
                "<tweet118>I love this guy \uD83D\uDE18\uD83D\uDC4D\uD83C\uDFFC\uD83E\uDD74 https://t.co/L5D0Fteq5C</tweet118>\n" +
                "<tweet119>@mmpadellan @BarackObama @graceslick77 In a parallel universe you’re still my President  \uD83D\uDE4C\uD83D\uDE4F</tweet119>\n" +
                "<tweet120>#womeninspire https://t.co/aUPhVjHyaM</tweet120>\n" +
                "<tweet121>@tonyschwartz No it speaks volumes about our society and the cult of celebrity personalities. We’ve lost our values… https://t.co/jmlsiQaAP0</tweet121>\n" +
                "<tweet122>#womeninspire #TIME100 \uD83D\uDE4C https://t.co/Xilc4DqiOQ</tweet122>\n" +
                "<tweet123>#thankyou to all my amazing friends &amp; family for the b day wishes ❤️❤️\uD83D\uDE4C❤️. A pivotal year ahead with a new film and… https://t.co/A27A8TWQ4c</tweet123>\n" +
                "<tweet124>@Dutch1968 @tonyschwartz I think Kim Kardashian is next in line for the Purple Heart.</tweet124>\n" +
                "<tweet125>‘Guard your candle, not everyone you meet deserves your light.’~ r.h. Sin. #truth \uD83D\uDCA1#saturdayvibes #blondewisdom… https://t.co/HQPnn3fois</tweet125>\n" +
                "<tweet126>Thank you for the wonderful article about my internationally award winning film, Growing up\n" +
                "FAT and Albanian, now a… https://t.co/HF1SJPOV39</tweet126>\n" +
                "<tweet127>@romyreiner My happy place https://t.co/5b0Et3pN8p</tweet127>\n" +
                "<tweet128>I’d rather welcome change than  cling to the past. #leatherpants &amp; all \uD83E\uDD18\uD83D\uDE0A\uD83D\uDCAA\uD83C\uDFFC. #staywoke  #stayinthelight… https://t.co/vfuoCSR9dG</tweet128>\n" +
                "<tweet129>@mama_tay0930 @TiffanyDCross I believe it’s called ‘self entitled millennial &amp; my dad got me this job so I’m gonna… https://t.co/XZDNaYDV14</tweet129>\n" +
                "<tweet130>Supporting Women’s Stories They matter. #awardwinning #film #womenmakemovies @FATAlbanianThe1 - https://t.co/vhLIEboUPr via @shareaholic</tweet130>\n" +
                "<tweet131>#womeninspire https://t.co/jz46imvz9q</tweet131>\n" +
                "<tweet132>@EdanClay @realDonaldTrump I believe ‘dumb as shit’ is the appropriate NY Queens term for @POTUS . Signed, Proud NY er</tweet132>\n" +
                "<tweet133>BONJOUR NICE.. our #20th film festival this May . Now available at https://t.co/Nra1WnBSTo . #p #filmfestivals… https://t.co/lqzdWynvNZ</tweet133>\n" +
                "<tweet134>To go back to your high school to screen your #awardwinning #film @elzazagreda  and see your favorite teachers who… https://t.co/4JsNtkkSHz</tweet134>\n" +
                "<tweet135>#bravo \uD83D\uDE4C\uD83D\uDE4C\uD83D\uDE4C\uD83D\uDE4C https://t.co/KwV8eywNqF</tweet135>\n" +
                "<tweet136>#womeninspire \uD83D\uDE4C https://t.co/IocmVEWuFb</tweet136>\n" +
                "<tweet137>Brilliant https://t.co/KbzdwC7CZN</tweet137>\n" +
                "<tweet138>Spoken from the mouths of babes... https://t.co/QzV9pc6GMP</tweet138>\n" +
                "<tweet139>Hmmm.. now WHERE could  she possibly be from with that red and black Albanian Eagle? \uD83D\uDE1C \uD83E\uDD37\u200D♀️? We’ve screened our… https://t.co/rDgSsONBGs</tweet139>\n" +
                "<tweet140>@ProgressiveRadM @HenryArkwright @neal_katyal No, to quote the immortal Britney Spears...’OOPS, I did it again.’ Yu… https://t.co/d54PrTcSr7</tweet140>\n" +
                "<tweet141>#womeninspire https://t.co/GHq4vslty2</tweet141>\n" +
                "<tweet142>@metsfan623 @BetteMidler To quote the great Britney Spears : ‘Oops he did it again. He played with our hearts.’… https://t.co/VzpmInXoBn</tweet142>\n" +
                "<tweet143>@BarbMcQuade I just have one comment “OOPS, he did it again.’ #nojustice</tweet143>\n" +
                "<tweet144>@in_pubs @realDonaldTrump Let’s not get too excited. Just remember the nightmare &amp; shock we all woke up to that icy… https://t.co/Bob3dq8KpK</tweet144>\n" +
                "<tweet145>@ItsHaseeb_ @VinayOstwal27 @instagram Yup nothing works. They don’t care</tweet145>\n" +
                "<tweet146>@graspingroots @JayHypnotic @instagram Happened to me ... 2X . Afraid to disable / and start from scratch. #notcool</tweet146>\n" +
                "<tweet147>@PrincesWrld @pretty_imani14 @instagram No it doesn’t</tweet147>\n" +
                "<tweet148>@ooshdesign @barbls23 @AmandiOnAir @HillaryClinton She 1999% deserves it. It was literally stolen from her. EVERY d… https://t.co/K8BOf4RwBK</tweet148>\n" +
                "<tweet149>@AmyKinLA @davenadelberg A former pro baseball athlete actually called me ‘transgendered’ after I turned him down o… https://t.co/fPin8aIrm1</tweet149>\n" +
                "<tweet150>@crymeariver6666 @realDonaldTrump Believe a #sociopath  at his 1st LIE. We’re passed 8,500 @POTUS while just in off… https://t.co/KvHVnQc3qO</tweet150>\n" +
                "<tweet151>Not only do I feel grateful to act, write and produce  an #awardwinning #film but the utmost honor to actually TEAC… https://t.co/9aj61emQDO</tweet151>\n" +
                "<tweet152>@der_Radek @ava @shaunking I couldn’t agree with you more. They are beautiful just the way they are, no head accessories required.</tweet152>\n" +
                "<tweet153>#womeninspire https://t.co/DdTLKPFAKX</tweet153>\n" +
                "<tweet154>#womeninspire #RBGBirthday #rbg #hero https://t.co/nggqKryZ4G</tweet154>\n" +
                "<tweet155>#TruthMatters #AdmissionsScam https://t.co/6iBCgf4tbr</tweet155>\n" +
                "<tweet156>When your mom Is SO EXCITED not that you’re playing Jill Kargman’s over the the top, domineering Russian housekeepe… https://t.co/WAYtQpcy0y</tweet156>\n" +
                "<tweet157>Oh Martha Stewart.. eat your heart out!! I can play happy homemaker on TV but I’d rather write, act,  produce &amp; mak… https://t.co/EPOI3g9IlY</tweet157>\n" +
                "<tweet158>Oh Martha Stewart.. eat your heart out!! I can play happy homemaker on TV but I’d rather write, act,  produce &amp; mak… https://t.co/qaloldYUlZ</tweet158>\n" +
                "<tweet159>@_SJPeace_ #womeninspire</tweet159>\n" +
                "<tweet160>Still celebrating International Woman’s Day \uD83D\uDE18. #saturdayvibes #keepingitreal #happyinternationalwomensday… https://t.co/diTS7stSZK</tweet160>\n" +
                "<tweet161>@mamaw3diane @feministabulous That’s because he is.</tweet161>\n" +
                "<tweet162>@HillaryClinton @AlexArg81560421 And America just got woke. \uD83D\uDE4C</tweet162>\n" +
                "<tweet163>Before there was an #awardwinning #film  @elzazagreda there was the sold out comedy with the best grossing sales at… https://t.co/LysR2gxymr</tweet163>\n" +
                "<tweet164>Sometimes I get nostalgic and look back. Then I turn around and say... ‘Nah, I’m good.’ \uD83D\uDE4C\uD83D\uDC4D\uD83C\uDFFC\uD83D\uDCAA\uD83C\uDFFC #igotthis… https://t.co/TvlTgRQDaZ</tweet164>\n" +
                "<tweet165>@phidippides26 @chelseahandler This is amazing. Self care is not a one size fits all. You can do so many things her… https://t.co/M45MWXgwSu</tweet165>\n" +
                "<tweet166>@Caissie Ummm let’s fast forward to the Pedophile ‘King of Pop’ where Michael Jackson and his buddies literally cha… https://t.co/pU6BG19sqe</tweet166>\n" +
                "<tweet167>#womeninspire https://t.co/Kdcm6wVK6Y</tweet167>\n" +
                "<tweet168>Age ain’t nothing but a number. #womeninspire https://t.co/Tv51A6v6sU</tweet168>\n" +
                "<tweet169>@tonyschwartz The apple doesn’t fall from the tree. She’s a Stepford wife &amp; daughter. Vapid &amp; Soulless</tweet169>\n" +
                "<tweet170>@Khillin_It @dragonroom1 @TheKarmiDance @treasonstickers It’s pretty funny when you don’t even know her or anyone o… https://t.co/OYjMlU4vBy</tweet170>\n" +
                "<tweet171>#HappyWomensHistoryMonth https://t.co/eUkG6WSFYQ</tweet171>\n" +
                "<tweet172>@fjcoughlin @donsoroka2011 @krassenstein Happy Women’s History month \uD83D\uDC4F</tweet172>\n" +
                "<tweet173>@DebraFlachner @JillWineBanks Lost count how many laws he’s broken. Yet NOTHING happens. Again. #overit #STOP</tweet173>\n" +
                "<tweet174>YAY! We get a WHOLE month.. then it’s back to the basement. #WomensHistoryMonth #LUCKY https://t.co/Q3htZYU0T4</tweet174>\n" +
                "<tweet175>Keep calm &amp; stand Tall. Leather pants &amp; all \uD83D\uDE0A\uD83D\uDCAA\uD83C\uDFFC #imdoingme #blondewisdom #elzazagreda #femalefilmmakerfriday… https://t.co/bRdJqyZIYW</tweet175>\n" +
                "<tweet176>Keep calm &amp; stand Tall. Leather pants &amp; all \uD83D\uDE0A\uD83D\uDCAA\uD83C\uDFFC #imdoingme #blondewisdom #elzazagreda #femalefilmmakerfriday… https://t.co/0yb1UvwFb7</tweet176>\n" +
                "<tweet177>I act, write, produce an #awardwinning #indiefilm @elzazagreda but I’m learning to sing &amp; play piano so Bradley Coo… https://t.co/GfD4R0uPiz</tweet177>\n" +
                "<tweet178>I write, act, I produce an #awardwinning  #film @elzazagreda ... but I’m learning to sing and play piano so Bradley… https://t.co/02NUFFbUMm</tweet178>\n" +
                "<tweet179>‘Immigrants and women move humanity forward.’~Chef Jose Andres. I’m so proud and blessed to share just a small frac… https://t.co/nJEnI9ri6Z</tweet179>\n" +
                "<tweet180>Although I was rooting for my girl Glenn , Olivia Coleman’s speech alone should get an Oscar. #truth #OSCARS… https://t.co/RxP2eQCMr7</tweet180>\n" +
                "<tweet181>#womeninspire #OscarsSoWoke #AcademyAwards2019 https://t.co/89EzPdPwKv</tweet181>\n" +
                "<tweet182>And she’ll still knock it out of the park. AGAIN . #GlennClose #sowrong #womeninspire https://t.co/OaTnW0JtSd</tweet182>\n" +
                "<tweet183>Regina is a King . #ReginaKing #oscars19 #womeninspire</tweet183>\n" +
                "<tweet184>@thedailybeast @josephlongo_ Go GLEN GO! So well deserved . And would argue her BEST performance seething with so m… https://t.co/hLaBwKdZSi</tweet184>\n" +
                "<tweet185>GO GLENN GO! #womeninspire #Oscars2019 #GlennClose https://t.co/lOa1A8XH3N</tweet185>\n" +
                "<tweet186>Kindness still Trumps Evil. Thk u @jaketapper . For the 1st time in my life I can say  I wished I lived in Texas, I… https://t.co/XcBu9I3wKF</tweet186>\n" +
                "<tweet187>Have your own back before you can get anybody else’s. And just smile while you do it. #doyou #elzazagreda… https://t.co/hdB9ONqYs3</tweet187>\n" +
                "<tweet188>#womeninspire https://t.co/gv4I1sO1pY</tweet188>\n" +
                "<tweet189>What a sad day. Thank you for your graciousness BOTH times I met you in Europe. And most of all, I loved your charm… https://t.co/RyTTvfzGW9</tweet189>\n" +
                "<tweet190>Mood: Running into your Ex at brunch and he looks 9 months pregnant. Maybe you should put down that croissant \uD83E\uDD50 ?… https://t.co/LZCUnnJwqh</tweet190>\n" +
                "<tweet191>‘I believe in pink.\uD83C\uDF38. I believe that laughing is the best calorie burner.’ ~ Audrey Hepburn. #metoo… https://t.co/1oKm63abTQ</tweet191>\n" +
                "<tweet192>‘I believe in pink.\uD83C\uDF38. I believe that laughing is the best calorie burner.’ ~ Audrey Hepburn. #metoo #pinkpower… https://t.co/7ShLZ9vTGY</tweet192>\n" +
                "<tweet193>@tehsilentcircus @ray_gull @maggieNYT And they just keep getting away with it .</tweet193>\n" +
                "<tweet194>#womeninspire #WomenInWhite https://t.co/q7pHUs2Hve</tweet194>\n" +
                "<tweet195>@lety02 @Mimirocah1 @RVAwonk @RepAdamSchiff Maybe Anna Wintour could give @SpeakerPelosi the cover of Vogue instead… https://t.co/fXfTZjujrB</tweet195>\n" +
                "<tweet196>She paved the way for the other female Pres. hopefuls #truth @HillaryClinton https://t.co/CMz8X4I2lx</tweet196>\n" +
                "<tweet197>Painful . I was waiting for the Sound of Music to come on. #StateOfTheUnionAddress #lieslielies  @realDonaldTrump</tweet197>\n" +
                "<tweet198>Well it looks like I’ll be working from home, WOMEN can NEVER LEAVE THERE HOMES AGAIN ... M13 &amp; illegal aliens are… https://t.co/bWByErxgRw</tweet198>\n" +
                "<tweet199>Why 1st lady look like Cruella  @RogueFirstLady vear black &amp; standing ovation? Donnie no give her memo? #bebest… https://t.co/u3FNzSe9Gq</tweet199>\n" +
                "<tweet200>#womeninspire https://t.co/uvv2sQ5Btx</tweet200>\n" +
                "<user3>1167074474337984512</user3>\n" +
                "<tweet1>They keep asking, why don’t you come home and find a full-time job to support the family? I feel so conflicted, but… https://t.co/tLFNFDDX0R</tweet1>\n" +
                "<tweet2>Felt incredible to be here at SfN and got to hear from so many amazing scientists and the difference that they make… https://t.co/y3l9v39GTn</tweet2>\n" +
                "<tweet3>This is my cat enjoying the neda walk paraphernalia #catpredicament https://t.co/PuwCARVWZ4</tweet3>\n" +
                "<tweet4>It was a beautiful morning to cross the Brooklyn bridge to attend the #NEDAWalk! It was so great to join Dr. Chiye… https://t.co/bUOyOGRvIY</tweet4>\n" +
                "<user4>1181277758854488064</user4>\n" +
                "<tweet1>TGIF and I am soooo excited! Completed Eco Columns by my #APES Students! #nycpublicschools #apenvironmentalscience… https://t.co/0zjpg1iOod</tweet1>\n" +
                "<tweet2>Aquatic Chamber constructed by my #APES Students for their eco columns. Adding Fish is up next! #nycpublicschools… https://t.co/RsOM1lVVbD</tweet2>\n" +
                "<tweet3>Aquatic Chamber constructed by my #APES Students for their eco columns. Adding Fish is up next! #nycpublicschools… https://t.co/5ZIF2McUyu</tweet3>\n" +
                "<tweet4>Are you living or existing? #FoodForThought maximize your life! #liveyourbestlife</tweet4>\n" +
                "<tweet5>\"I've learned that people will forget what you said, people will forget what you did, but people will never forget… https://t.co/10EVFAj3sg</tweet5>\n" +
                "<tweet6>Aquatic Chamber constructed by my #APES Students for their eco columns. Adding Fish is up next! #nycpublicschools… https://t.co/w9gR4WsIo5</tweet6>\n" +
                "<tweet7>\uD83D\uDE02too funny #WackyWednesday #nycdoe #nycpublicschools #nycscienceteacher #mathforamerica #MFA https://t.co/pCWgosHaTv</tweet7>\n" +
                "<tweet8>#APES AP Environment Students tending to their ecocolumns! The beans have sprouted in their Terrestrial Chamber.… https://t.co/555jmMKKUS</tweet8>\n" +
                "<tweet9>I am MfA Proud because I am privileged to collaborate with amazing teachers to share strategies, ideas, opportuniti… https://t.co/rQO5dnLWKM</tweet9>\n" +
                "<tweet10>@Dev_Gnarley Hall and Oates</tweet10>\n" +
                "<tweet11>@MatthewACherry Hall and Oates also</tweet11>\n" +
                "<tweet12>https://t.co/6UAdPar85x\n" +
                "\n" +
                "My Amazon Teacher Wish List! Anything helps me help my students to Make America Great!</tweet12>\n" +
                "<tweet13>My AP Environmental Science students Eco columns in the making! Stay tuned! #nycpublicschool #APForAll #APES… https://t.co/YfzXknUOia</tweet13>\n" +
                "<tweet14>I ❤️ NY #mycity #nyc https://t.co/erylvgoZ0j</tweet14>\n" +
                "<tweet15>When your students create a hydroponics system from scratch? #mathforamerica #Hydroponics #nycpublicschool… https://t.co/kyTqhutbs6</tweet15>\n" +
                "<user5>1187567834437697536</user5>\n" +
                "<tweet1>@arr1910 @nadjabreton Pero pues sí él representa esa tradición de Morena de los \"mapaches\", la tranza y la corrupción... ¿De qué se queja?</tweet1>\n" +
                "<tweet2>@ponchoherrera @azucenau Cierto, pero está vez es evidente que las y los policías no tuvieron una responsabilidad d… https://t.co/iD249bSCcv</tweet2>\n" +
                "<tweet3>@72Lindero @azucenau Tenemos un Narcopresidente, una inepta jefa de gobierno,cuyos funcionarios más cercanos proteg… https://t.co/UEYiilComy</tweet3>\n" +
                "<tweet4>@qtf @drjoseoscarv El daños que pudo haber causado un artículo como ese, no justifica la popularidad de quiénes buscaban impulsarlo.</tweet4>\n" +
                "<tweet5>@notibomba @aran_tirado @lopezobrador_ Pues esto del socialismo tembeleque de López Obrador no veo que haga crecer… https://t.co/s4iALgQRmb</tweet5>\n" +
                "<tweet6>@guruchuirer @abarrotesgab Ahora sí López Obrador será el único en robar el presupuesto completo.</tweet6>\n" +
                "<tweet7>@faycastel Gracias colega por tu valiosa aportación, sin embargo, la duda es si es legal venderla fría o no #sarcasmo</tweet7>\n" +
                "<tweet8>@kdartigues Andrés Manuel López Obrador sin el narcotráfico</tweet8>\n" +
                "<tweet9>@patriciajaniot México no, el presidente López Obrador, que es su socio y los protege y solapa.</tweet9>\n" +
                "<tweet10>@Foro_TV El Presidente Trump, quien lleva años en la Casa Blanca, había pensado que el apelativo \"Nuevo\" México, ha… https://t.co/CTKVKbz7Ef</tweet10>\n" +
                "<tweet11>@Pajaropolitico @jenarovillamil Cuántos jueces con apellido Padierna, hasta se me hace que son una especie de corporación, ¿no?</tweet11>\n" +
                "<user6>134711882</user6>\n" +
                "<tweet1>Unf****in BELIEVABLE. We have officially reentered the Dark Ages. #HarveyWeinstein #HardToSee https://t.co/AnQFbGw7K2</tweet1>\n" +
                "<tweet2>@NouveauBougee @OhNoSheTwitnt It’s called white male privilege. But it doesn’t really exist. Just like climate chan… https://t.co/uQHBEUUUST</tweet2>\n" +
                "<tweet3>#TruthExposed https://t.co/yYrxqkDEwS</tweet3>\n" +
                "<tweet4>@lydiamarieguti1 @larzilar @JXESAID Who’s buying them? The deplorables maybe..? You know the ones who want us to go… https://t.co/JJ971ULGhe</tweet4>\n" +
                "<tweet5>@guelphgirlchris My ex who  was also a sociopath &amp; pathological liar was also  from the area. Explains a lot .</tweet5>\n" +
                "<tweet6>If I sat around and listened to all the advice the ‘experts’ gave me - ‘you don’t have enough $$$, you can’t do it,… https://t.co/S6iCV1IpHN</tweet6>\n" +
                "<tweet7>‘I live my live with pain, passion &amp; purpose’~ Elijah Cummings. Tear gassed, beaten ..RIP , Warrior  you inspired g… https://t.co/jAjIRzrLvc</tweet7>\n" +
                "<tweet8>#womeninspire https://t.co/1Q463m3NR0</tweet8>\n" +
                "<tweet9>@hellolanemoore Preach, sister, preach. Having good friends, a clean conscience, goals, ambitions to wake up to eve… https://t.co/PxlmF1oM3D</tweet9>\n" +
                "<tweet10>#WomenLeadTheWay . Preach sister, preach. Go Jameela \uD83D\uDE4C\uD83D\uDC4D\uD83C\uDFFC\uD83D\uDC83 https://t.co/m2ddRoZeLA</tweet10>\n" +
                "<tweet11>@lynndelaney @ProfaneFeminist Umm that’s RIGHT, be grateful you’re ALIVE today and you don’t need a man to validate… https://t.co/wKYapjqiiI</tweet11>\n" +
                "<tweet12>#womeninspire https://t.co/N3yy2ir1NK</tweet12>\n" +
                "<tweet13>#womeninspire https://t.co/AZnhOMyaZe</tweet13>\n" +
                "<tweet14>Just saying\uD83D\uDC8B. #beware #elzazagreda #femalefilmmaker #femalefilmmakerfriday #awardwinner @elzazagreda #proudproducer… https://t.co/IVsIg5MURi</tweet14>\n" +
                "<tweet15>Just saying\uD83D\uDC8B. #beware #elzazagreda #femalefilmmaker #femalefilmmakerfriday #awardwinner @elzazagreda #proudproducer… https://t.co/CHFmcZt6vP</tweet15>\n" +
                "<tweet16>#WomanCrushWednesday https://t.co/YTgqpywhZE</tweet16>\n" +
                "<tweet17>@HillaryClinton @realDonaldTrump Pretty please \uD83D\uDE4F. Yes Hillary \uD83C\uDFC3\u200D♀️!!! \uD83D\uDE4C\uD83D\uDE4C\uD83D\uDE4C\uD83D\uDE4C\uD83D\uDE4C\uD83D\uDE4C\uD83D\uDE4C\uD83D\uDE4C\uD83D\uDE4C\uD83D\uDE4C\uD83D\uDE4C\uD83D\uDE4C</tweet17>\n" +
                "<tweet18>#WomenChangingTheWorld #womeninspire #KurdsBetrayedByTrump #shameful https://t.co/mfw6A7mH21</tweet18>\n" +
                "<tweet19>@rhorseranch_joy Please God, please. \uD83D\uDE4F#GutsyWomen #Hillary #imstillwithher</tweet19>\n" +
                "<tweet20>#womeninspire #RIPDiahannCarroll #legend https://t.co/WfxpEAoWgY</tweet20>\n" +
                "<tweet21>Damn right she has a life— THEN &amp; Now. And we were robbed of a President— who acts like a President. And she won’t… https://t.co/vtnO3Qnv6o</tweet21>\n" +
                "<tweet22>You can’t keep a good woman down. #ImStillWithHer https://t.co/CsC3BENXqm</tweet22>\n" +
                "<tweet23>@NYMag @onesarahjones Wow, can we say misogyny is alive and well? Thanks, point taken Sara. \uD83D\uDC4D\uD83C\uDFFC</tweet23>\n" +
                "<tweet24>#womeninspire https://t.co/MNfNIiLNc8</tweet24>\n" +
                "<tweet25>@Newsweek Getting my burka with the open eye slits on now. Excellent . \uD83D\uDE4F\uD83D\uDC4D\uD83C\uDFFC</tweet25>\n" +
                "<tweet26>London got me like...... \uD83C\uDDEC\uD83C\uDDE7 #happyblonde #elzazagreda #awardwinner #femalefilmmaker #londonista  #londoncalling… https://t.co/dX3GHx5rpp</tweet26>\n" +
                "<tweet27>#womeninspire #badasswomen https://t.co/8trxwpRbj4</tweet27>\n" +
                "<tweet28>#ImStillWithHer #IllegitimatePresident #shameful https://t.co/8KjpeEt4st</tweet28>\n" +
                "<tweet29>#womeninspire #ChristineBlaseyFord https://t.co/qAIvImm7pj</tweet29>\n" +
                "<tweet30>#womeninspire @ava https://t.co/FSe7dHxh9I</tweet30>\n" +
                "<tweet31>Just goes to show age is just a number.  I want to look like that NOW. #womeninspire #womeninfilm https://t.co/hVMqHgYN3Z</tweet31>\n" +
                "<tweet32>@KennedyJReeves That’s my girl \uD83D\uDC4D\uD83C\uDFFC\uD83D\uDCAA\uD83C\uDFFC#girlpower #womeninspire</tweet32>\n" +
                "<tweet33>The 58th million reason #iloveny . It’s the only city where 600 people gather in #bryantpark and collectively do yo… https://t.co/6bmcis8gKY</tweet33>\n" +
                "<tweet34>@Sameddy80454656 @NYMag Only when she slaps his arm to say ‘don’t touch me.’</tweet34>\n" +
                "<tweet35>@exoticgamora and while at it, let’s stone them to death and throw acid in their faces, that will shut us up for sure \uD83D\uDC4D\uD83C\uDFFC</tweet35>\n" +
                "<tweet36>And I think we should start stoning them too. https://t.co/yHFEMH9WKD</tweet36>\n" +
                "<tweet37>Back, white , yellow, ... Women Inspire. This just became my daily affirmation. All hail the Queen . \uD83D\uDE4F… https://t.co/EtSoihiJcP</tweet37>\n" +
                "<tweet38>My back to work/ school outfit. Sophia Loren meets Hemingway \uD83D\uDE0A .#elzazagreda #femalefilmmaker… https://t.co/sqcr1ni1NJ</tweet38>\n" +
                "<tweet39>West Coast, East Coast.. LA, NYC, Miami, in an ER in the city..\uD83D\uDE0A ( shout out to Nurse DRAGO, you were the best ! )… https://t.co/SKuCezeX47</tweet39>\n" +
                "<tweet40>I’m still with her. https://t.co/CQaHUM5inV</tweet40>\n" +
                "<tweet41>@JoyceWhiteVance Our system is BROKEN. The constitution/ our forefathers were  not infallible. We need to find solu… https://t.co/bTFjLpMhZN</tweet41>\n" +
                "<tweet42>@ShelbyKStewart It was deteriorating at DAY 1. So over. Every day, every hour he gets away with it. It’s s banana r… https://t.co/NAE73YsEeN</tweet42>\n" +
                "<tweet43>Wait, WHAT do you mean I won for Best Original Screenplay in London for my wildly popular film @elzazagreda ?\uD83E\uDD37\u200D♀️\uD83D\uDC83\uD83D\uDE0A… https://t.co/j5eHIRyUsq</tweet43>\n" +
                "<tweet44>@Frances_Fisher @yashar @marwilliamson I actually prefer the 1st tweet.</tweet44>\n" +
                "<tweet45>#womeninspire https://t.co/mAyY1jy6hF</tweet45>\n" +
                "<tweet46>Wait, does the 6 train stop here, I’m confused ? .. is this Staten Island or something, where’s midtown?… https://t.co/vMxVXNa6IF</tweet46>\n" +
                "<tweet47>If you want to find a serial killer or pedophile, tinder is the way to go. \uD83D\uDC4D\uD83C\uDFFC. #onlinedating #JustSaying #JustSayNo https://t.co/u8VcZTzew0</tweet47>\n" +
                "<tweet48>Ok, bags packed, ready to go.\uD83D\uDCAA\uD83C\uDFFC.....got a film ( and play) ready to roll. #yourestyourust #elzazagreda… https://t.co/n0DrASrlml</tweet48>\n" +
                "<tweet49>Be the captain of your own ship. #elzazagreda #femalefilmmaker #awardwinner @elzazagreda #femalefilmmakerfriday… https://t.co/SYaFWhLnBy</tweet49>\n" +
                "<tweet50>Bad Ass \uD83D\uDCAA\uD83C\uDFFC#RBG #RuthBaderGinsburg https://t.co/sqbGYF0pVX</tweet50>\n" +
                "<tweet51>@SarahKSilverman Sounds a lot like my ex husband.</tweet51>\n" +
                "<tweet52>Women inspire. #justdoit https://t.co/lEwfcUAV0S</tweet52>\n" +
                "<tweet53>Rest In Peace you Beautiful Soul. \uD83D\uDE4F Tortured, misunderstood, abandoned, motherless, a child bride, abused ... yet y… https://t.co/2e8NgRdENw</tweet53>\n" +
                "<tweet54>\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A https://t.co/WSftLi5eTX</tweet54>\n" +
                "<tweet55>She said YES. #womeninspire https://t.co/uIm12R6UeN</tweet55>\n" +
                "<tweet56>Not sure you can call it work when you get to do what you love ❤️ with people you ❤️ , the people you love come and… https://t.co/doOWEK14V9</tweet56>\n" +
                "<tweet57>@yank1tig @HuffPost And they Made America Great Again!! #thankyou  @mPinoe #WomensChampion #womensinspire #FIFAWWC</tweet57>\n" +
                "<tweet58>#WomensWorldCup2019 #womeninspire https://t.co/frgzIpRUYh</tweet58>\n" +
                "<tweet59>#womeninspire https://t.co/zmOIZlgj3W</tweet59>\n" +
                "<tweet60>I miss this. Appreciate the moments .❤️❤️❤️ #thelittlethings #restrelaxrecharge #candid #goodfriendsgoodtimes… https://t.co/0ISZUgsTZu</tweet60>\n" +
                "<tweet61>#womeninspire #WomensWorldCup https://t.co/piXeu0zZ5B</tweet61>\n" +
                "<tweet62>The necklace says it all. ‘When you love what you do.” #jadore #dior #elzazagreda #awardwinning #femalefilmmaker… https://t.co/PF5IyRELQm</tweet62>\n" +
                "<tweet63>#womeninspire #hero #rbg https://t.co/TvczgUCFxK</tweet63>\n" +
                "<tweet64>@StopTrump2020 Total Eclipse of the Heart</tweet64>\n" +
                "<tweet65>My God. What have we become? \uD83E\uDD37\u200D♀️\uD83D\uDE14\uD83D\uDE4C #America https://t.co/Cfk3mBNbZz</tweet65>\n" +
                "<tweet66>After 1500 submissions including  48 from talent / agent submissions, with only 5 roles .. so thrilled to be workin… https://t.co/lJpYDzQZy8</tweet66>\n" +
                "<tweet67>\uD83D\uDCAA\uD83C\uDFFC\uD83D\uDCAA\uD83C\uDFFC\uD83D\uDCAA\uD83C\uDFFC\uD83D\uDCAA\uD83C\uDFFC\uD83D\uDCAA\uD83C\uDFFC\uD83D\uDCAA\uD83C\uDFFC https://t.co/vxuATt77TL</tweet67>\n" +
                "<tweet68>#womeninspire https://t.co/6N6PPlAQ9H</tweet68>\n" +
                "<tweet69>#womeninspire https://t.co/JAYWnAQvLQ</tweet69>\n" +
                "<tweet70>No excusar... I was told the 9 train stop here? I’ve got a play I just got cast in in #NYC &amp; Lyddie needs to head t… https://t.co/dlTv4iNzov</tweet70>\n" +
                "<tweet71>#damnright #ImStillWithHer @HillaryClinton @HillaryWarnedUs https://t.co/McD8omj8l2</tweet71>\n" +
                "<tweet72>Excuse me.. does the #6 train stop here? #elzazagreda #femalefilmmaker #straphanger #majorca #heavenisaplaceonearth… https://t.co/dFjVGPXSho</tweet72>\n" +
                "<tweet73>#womeninspire https://t.co/aecgk1dWJw</tweet73>\n" +
                "<tweet74>@kgoss1128 @crymeariver6666 @GovMikeHuckabee @realDonaldTrump @PressSec @POTUS I mean they weren’t REAL COMPLIMENTS… https://t.co/mI7LbK2nFX</tweet74>\n" +
                "<tweet75>#womeninspire #ElizabethWarren \uD83D\uDC4D\uD83C\uDFFC #preach https://t.co/dftZM1trjC</tweet75>\n" +
                "<tweet76>Thank you to the beautiful Spanish senorita  cancotahotel for making my stay in Majorca so spectacular. An… https://t.co/uZ3ASiR6B2</tweet76>\n" +
                "<tweet77>Move over, John Travolta.. you ain’t the only one rockin that white pantsuit from Saturday Night Fever. I’m ready f… https://t.co/stJx9gpAbU</tweet77>\n" +
                "<tweet78>Move over, John Travolta.. you ain’t the only one rockin that white pantsuit from Saturday Night Fever. I’m ready f… https://t.co/ZhGPZspOeN</tweet78>\n" +
                "<tweet79>@johnpavlovitz It was amazing to be in Majorca on a yoga retreat and NOT ONCE have to see or listen to the buffoon… https://t.co/K8KI7f7c3d</tweet79>\n" +
                "<tweet80>@Courage20192112 @homemadeguitars @zunderwhelmed @nytimes The day after Madame President lost I immediately cancell… https://t.co/8OmBV8lXkO</tweet80>\n" +
                "<tweet81>#womeninspire https://t.co/XWvE24ReYh</tweet81>\n" +
                "<tweet82>I’m still with her . #Hillary2020 https://t.co/NfASvdZwAu</tweet82>\n" +
                "<tweet83>I entered the @BurnThisBway Lottery for $39 tickets on @TodayTix! Tap here to enter: https://t.co/ujYeAd7YbO #fingerscrossed</tweet83>\n" +
                "<tweet84>#truth https://t.co/yieSqzx4U2</tweet84>\n" +
                "<tweet85>#womeninspire \uD83D\uDE4C\uD83D\uDE4C\uD83D\uDE4C https://t.co/p9Q7oBUTYN</tweet85>\n" +
                "<tweet86>Yet again he goes unpunished. Why do we even have a Congress? \uD83E\uDD37\u200D♀️ #disgusting #DoSomething https://t.co/JNWtvQAJ9d</tweet86>\n" +
                "<tweet87>#womeninspire https://t.co/MV8PiH8NVY</tweet87>\n" +
                "<tweet88>‘ I eat NO for breakfast.’ ~ Kamala Harris \uD83D\uDCAA\uD83C\uDFFC. Alabama, Georgia, Missouri, where a rapist has more rights than a wo… https://t.co/bIi76pmcsN</tweet88>\n" +
                "<tweet89>@fierysadness @AlexArg81560421 Wait ART imitating life in a Woody Allen film? Unbelievable. Nah, he’s not guilty....</tweet89>\n" +
                "<tweet90>#WomenRightsAreHumanRights https://t.co/RoXZv68lPs</tweet90>\n" +
                "<tweet91>#TruthHurts #womeninspire https://t.co/EDNe1NuGnZ</tweet91>\n" +
                "<tweet92>#womeninspire https://t.co/krA2vfuIla</tweet92>\n" +
                "<tweet93>Start me up. You make a grown man cry. #ageisjustanumber https://t.co/6xvUw5Azg5</tweet93>\n" +
                "<tweet94>@Rosie Well c’mon now.. she can say ‘HI’ fluently in 8 languages and all.. that must count for something? \uD83D\uDE0A\uD83E\uDD37\u200D♀️\uD83D\uDE33</tweet94>\n" +
                "<tweet95>#truth https://t.co/4k5WwlLWTF</tweet95>\n" +
                "<tweet96>Shocked and Surprised. ❤️\uD83D\uDC4D\uD83C\uDFFC #not #iloveny https://t.co/DVz7aXAhlf</tweet96>\n" +
                "<tweet97>@girlsreallyrule @ananavarro @MeghanMcCain She only confirms the narrative that patriarchy is not only alive and we… https://t.co/f3JYeGpXpA</tweet97>\n" +
                "<tweet98>#womeninspire https://t.co/FjdUSjBof1</tweet98>\n" +
                "<tweet99>#womeninspire https://t.co/yKUenXxiqr</tweet99>\n" +
                "<tweet100>Always brilliantly spot on. Not only would you make a fierce  president,  but we’d laugh our asses every day, in a… https://t.co/GqPdPPRIFU</tweet100>\n" +
                "<tweet101>#womeninspire https://t.co/pNLIQdGUgG</tweet101>\n" +
                "<tweet102>‘You have to believe. You have to be hopeful. You have to be optimistic.’~ The Great Senator John Lewis. If this li… https://t.co/0RIjzQRZUc</tweet102>\n" +
                "<tweet103>@KennedyJReeves You GOT THIS! \uD83D\uDC4D\uD83C\uDFFCthink Norma Rae.....</tweet103>\n" +
                "<tweet104>@dhannah412 @hawkeye1x @chrislhayes But he gets away with it. Every Single Day. STOP SHOWING IT . #EnoughSaid</tweet104>\n" +
                "<tweet105>@joaninDC61 @CyrusMMcQueen @MeghanMcCain You absolutely nailed it. As Gloria Steinem gloriously notes ‘we live in a… https://t.co/jRxTKxgOcT</tweet105>\n" +
                "<tweet106>#womeninspire https://t.co/Hbw93nJhar</tweet106>\n" +
                "<tweet107>It might not be the #metgala this year..but with a little drive, vision &amp; ambition, a girl can dream. #elzazagreda… https://t.co/1qefgPT0Gz</tweet107>\n" +
                "<tweet108>#womeninspire https://t.co/HWLR78DYwX</tweet108>\n" +
                "<tweet109>#womeninspire https://t.co/tivSavYTlk</tweet109>\n" +
                "<tweet110>Kosovo War Rape Victim Urges US Congress to Seek Justice https://t.co/bMXTs5deOj</tweet110>\n" +
                "<tweet111>#womeninspire https://t.co/AhZxXoN4Bl</tweet111>\n" +
                "<tweet112>I might not be Amal Clooney..but so loud and proud to lend my voice, my heart and soul to these amazing heroes who… https://t.co/5L6BPiD2du</tweet112>\n" +
                "<tweet113>SO loud &amp; proud of the #heroes .  Kosovo  War Rape Victim Urges US Congress to Seek Justice https://t.co/bMXTs5deOj\n" +
                "#womeninspire #justice</tweet113>\n" +
                "<tweet114>Call to action. NEVER FORGET. 20,000 women &amp; men raped. 1,600 still missing, 13,950 killed #humanityfirst… https://t.co/L9cuKnY9PM</tweet114>\n" +
                "<tweet115>Nope, NOT having it. \uD83E\uDD1AWomen’s bodies are NOT commodities to be used as a weapon of war. Words MATTER. Rape, genocid… https://t.co/qfWfau2UNd</tweet115>\n" +
                "<tweet116>Story of my life . #truth https://t.co/GCCK5TrWZx</tweet116>\n" +
                "<tweet117>That’s RIGHT WASHINGTON!! here we come! These badasses can’t WAIT to take the Capital by Storm this Tuesday to prot… https://t.co/Z76zoNNx5x</tweet117>\n" +
                "<tweet118>I love this guy \uD83D\uDE18\uD83D\uDC4D\uD83C\uDFFC\uD83E\uDD74 https://t.co/L5D0Fteq5C</tweet118>\n" +
                "<tweet119>@mmpadellan @BarackObama @graceslick77 In a parallel universe you’re still my President  \uD83D\uDE4C\uD83D\uDE4F</tweet119>\n" +
                "<tweet120>#womeninspire https://t.co/aUPhVjHyaM</tweet120>\n" +
                "<tweet121>@tonyschwartz No it speaks volumes about our society and the cult of celebrity personalities. We’ve lost our values… https://t.co/jmlsiQaAP0</tweet121>\n" +
                "<tweet122>#womeninspire #TIME100 \uD83D\uDE4C https://t.co/Xilc4DqiOQ</tweet122>\n" +
                "<tweet123>#thankyou to all my amazing friends &amp; family for the b day wishes ❤️❤️\uD83D\uDE4C❤️. A pivotal year ahead with a new film and… https://t.co/A27A8TWQ4c</tweet123>\n" +
                "<tweet124>@Dutch1968 @tonyschwartz I think Kim Kardashian is next in line for the Purple Heart.</tweet124>\n" +
                "<tweet125>‘Guard your candle, not everyone you meet deserves your light.’~ r.h. Sin. #truth \uD83D\uDCA1#saturdayvibes #blondewisdom… https://t.co/HQPnn3fois</tweet125>\n" +
                "<tweet126>Thank you for the wonderful article about my internationally award winning film, Growing up\n" +
                "FAT and Albanian, now a… https://t.co/HF1SJPOV39</tweet126>\n" +
                "<tweet127>@romyreiner My happy place https://t.co/5b0Et3pN8p</tweet127>\n" +
                "<tweet128>I’d rather welcome change than  cling to the past. #leatherpants &amp; all \uD83E\uDD18\uD83D\uDE0A\uD83D\uDCAA\uD83C\uDFFC. #staywoke  #stayinthelight… https://t.co/vfuoCSR9dG</tweet128>\n" +
                "<tweet129>@mama_tay0930 @TiffanyDCross I believe it’s called ‘self entitled millennial &amp; my dad got me this job so I’m gonna… https://t.co/XZDNaYDV14</tweet129>\n" +
                "<tweet130>Supporting Women’s Stories They matter. #awardwinning #film #womenmakemovies @FATAlbanianThe1 - https://t.co/vhLIEboUPr via @shareaholic</tweet130>\n" +
                "<tweet131>#womeninspire https://t.co/jz46imvz9q</tweet131>\n" +
                "<tweet132>@EdanClay @realDonaldTrump I believe ‘dumb as shit’ is the appropriate NY Queens term for @POTUS . Signed, Proud NY er</tweet132>\n" +
                "<tweet133>BONJOUR NICE.. our #20th film festival this May . Now available at https://t.co/Nra1WnBSTo . #p #filmfestivals… https://t.co/lqzdWynvNZ</tweet133>\n" +
                "<tweet134>To go back to your high school to screen your #awardwinning #film @elzazagreda  and see your favorite teachers who… https://t.co/4JsNtkkSHz</tweet134>\n" +
                "<tweet135>#bravo \uD83D\uDE4C\uD83D\uDE4C\uD83D\uDE4C\uD83D\uDE4C https://t.co/KwV8eywNqF</tweet135>\n" +
                "<tweet136>#womeninspire \uD83D\uDE4C https://t.co/IocmVEWuFb</tweet136>\n" +
                "<tweet137>Brilliant https://t.co/KbzdwC7CZN</tweet137>\n" +
                "<tweet138>Spoken from the mouths of babes... https://t.co/QzV9pc6GMP</tweet138>\n" +
                "<tweet139>Hmmm.. now WHERE could  she possibly be from with that red and black Albanian Eagle? \uD83D\uDE1C \uD83E\uDD37\u200D♀️? We’ve screened our… https://t.co/rDgSsONBGs</tweet139>\n" +
                "<tweet140>@ProgressiveRadM @HenryArkwright @neal_katyal No, to quote the immortal Britney Spears...’OOPS, I did it again.’ Yu… https://t.co/d54PrTcSr7</tweet140>\n" +
                "<tweet141>#womeninspire https://t.co/GHq4vslty2</tweet141>\n" +
                "<tweet142>@metsfan623 @BetteMidler To quote the great Britney Spears : ‘Oops he did it again. He played with our hearts.’… https://t.co/VzpmInXoBn</tweet142>\n" +
                "<tweet143>@BarbMcQuade I just have one comment “OOPS, he did it again.’ #nojustice</tweet143>\n" +
                "<tweet144>@in_pubs @realDonaldTrump Let’s not get too excited. Just remember the nightmare &amp; shock we all woke up to that icy… https://t.co/Bob3dq8KpK</tweet144>\n" +
                "<tweet145>@ItsHaseeb_ @VinayOstwal27 @instagram Yup nothing works. They don’t care</tweet145>\n" +
                "<tweet146>@graspingroots @JayHypnotic @instagram Happened to me ... 2X . Afraid to disable / and start from scratch. #notcool</tweet146>\n" +
                "<tweet147>@PrincesWrld @pretty_imani14 @instagram No it doesn’t</tweet147>\n" +
                "<tweet148>@ooshdesign @barbls23 @AmandiOnAir @HillaryClinton She 1999% deserves it. It was literally stolen from her. EVERY d… https://t.co/K8BOf4RwBK</tweet148>\n" +
                "<tweet149>@AmyKinLA @davenadelberg A former pro baseball athlete actually called me ‘transgendered’ after I turned him down o… https://t.co/fPin8aIrm1</tweet149>\n" +
                "<tweet150>@crymeariver6666 @realDonaldTrump Believe a #sociopath  at his 1st LIE. We’re passed 8,500 @POTUS while just in off… https://t.co/KvHVnQc3qO</tweet150>\n" +
                "<tweet151>Not only do I feel grateful to act, write and produce  an #awardwinning #film but the utmost honor to actually TEAC… https://t.co/9aj61emQDO</tweet151>\n" +
                "<tweet152>@der_Radek @ava @shaunking I couldn’t agree with you more. They are beautiful just the way they are, no head accessories required.</tweet152>\n" +
                "<tweet153>#womeninspire https://t.co/DdTLKPFAKX</tweet153>\n" +
                "<tweet154>#womeninspire #RBGBirthday #rbg #hero https://t.co/nggqKryZ4G</tweet154>\n" +
                "<tweet155>#TruthMatters #AdmissionsScam https://t.co/6iBCgf4tbr</tweet155>\n" +
                "<tweet156>When your mom Is SO EXCITED not that you’re playing Jill Kargman’s over the the top, domineering Russian housekeepe… https://t.co/WAYtQpcy0y</tweet156>\n" +
                "<tweet157>Oh Martha Stewart.. eat your heart out!! I can play happy homemaker on TV but I’d rather write, act,  produce &amp; mak… https://t.co/EPOI3g9IlY</tweet157>\n" +
                "<tweet158>Oh Martha Stewart.. eat your heart out!! I can play happy homemaker on TV but I’d rather write, act,  produce &amp; mak… https://t.co/qaloldYUlZ</tweet158>\n" +
                "<tweet159>@_SJPeace_ #womeninspire</tweet159>\n" +
                "<tweet160>Still celebrating International Woman’s Day \uD83D\uDE18. #saturdayvibes #keepingitreal #happyinternationalwomensday… https://t.co/diTS7stSZK</tweet160>\n" +
                "<tweet161>@mamaw3diane @feministabulous That’s because he is.</tweet161>\n" +
                "<tweet162>@HillaryClinton @AlexArg81560421 And America just got woke. \uD83D\uDE4C</tweet162>\n" +
                "<tweet163>Before there was an #awardwinning #film  @elzazagreda there was the sold out comedy with the best grossing sales at… https://t.co/LysR2gxymr</tweet163>\n" +
                "<tweet164>Sometimes I get nostalgic and look back. Then I turn around and say... ‘Nah, I’m good.’ \uD83D\uDE4C\uD83D\uDC4D\uD83C\uDFFC\uD83D\uDCAA\uD83C\uDFFC #igotthis… https://t.co/TvlTgRQDaZ</tweet164>\n" +
                "<tweet165>@phidippides26 @chelseahandler This is amazing. Self care is not a one size fits all. You can do so many things her… https://t.co/M45MWXgwSu</tweet165>\n" +
                "<tweet166>@Caissie Ummm let’s fast forward to the Pedophile ‘King of Pop’ where Michael Jackson and his buddies literally cha… https://t.co/pU6BG19sqe</tweet166>\n" +
                "<tweet167>#womeninspire https://t.co/Kdcm6wVK6Y</tweet167>\n" +
                "<tweet168>Age ain’t nothing but a number. #womeninspire https://t.co/Tv51A6v6sU</tweet168>\n" +
                "<tweet169>@tonyschwartz The apple doesn’t fall from the tree. She’s a Stepford wife &amp; daughter. Vapid &amp; Soulless</tweet169>\n" +
                "<tweet170>@Khillin_It @dragonroom1 @TheKarmiDance @treasonstickers It’s pretty funny when you don’t even know her or anyone o… https://t.co/OYjMlU4vBy</tweet170>\n" +
                "<tweet171>#HappyWomensHistoryMonth https://t.co/eUkG6WSFYQ</tweet171>\n" +
                "<tweet172>@fjcoughlin @donsoroka2011 @krassenstein Happy Women’s History month \uD83D\uDC4F</tweet172>\n" +
                "<tweet173>@DebraFlachner @JillWineBanks Lost count how many laws he’s broken. Yet NOTHING happens. Again. #overit #STOP</tweet173>\n" +
                "<tweet174>YAY! We get a WHOLE month.. then it’s back to the basement. #WomensHistoryMonth #LUCKY https://t.co/Q3htZYU0T4</tweet174>\n" +
                "<tweet175>Keep calm &amp; stand Tall. Leather pants &amp; all \uD83D\uDE0A\uD83D\uDCAA\uD83C\uDFFC #imdoingme #blondewisdom #elzazagreda #femalefilmmakerfriday… https://t.co/bRdJqyZIYW</tweet175>\n" +
                "<tweet176>Keep calm &amp; stand Tall. Leather pants &amp; all \uD83D\uDE0A\uD83D\uDCAA\uD83C\uDFFC #imdoingme #blondewisdom #elzazagreda #femalefilmmakerfriday… https://t.co/0yb1UvwFb7</tweet176>\n" +
                "<tweet177>I act, write, produce an #awardwinning #indiefilm @elzazagreda but I’m learning to sing &amp; play piano so Bradley Coo… https://t.co/GfD4R0uPiz</tweet177>\n" +
                "<tweet178>I write, act, I produce an #awardwinning  #film @elzazagreda ... but I’m learning to sing and play piano so Bradley… https://t.co/02NUFFbUMm</tweet178>\n" +
                "<tweet179>‘Immigrants and women move humanity forward.’~Chef Jose Andres. I’m so proud and blessed to share just a small frac… https://t.co/nJEnI9ri6Z</tweet179>\n" +
                "<tweet180>Although I was rooting for my girl Glenn , Olivia Coleman’s speech alone should get an Oscar. #truth #OSCARS… https://t.co/RxP2eQCMr7</tweet180>\n" +
                "<tweet181>#womeninspire #OscarsSoWoke #AcademyAwards2019 https://t.co/89EzPdPwKv</tweet181>\n" +
                "<tweet182>And she’ll still knock it out of the park. AGAIN . #GlennClose #sowrong #womeninspire https://t.co/OaTnW0JtSd</tweet182>\n" +
                "<tweet183>Regina is a King . #ReginaKing #oscars19 #womeninspire</tweet183>\n" +
                "<tweet184>@thedailybeast @josephlongo_ Go GLEN GO! So well deserved . And would argue her BEST performance seething with so m… https://t.co/hLaBwKdZSi</tweet184>\n" +
                "<tweet185>GO GLENN GO! #womeninspire #Oscars2019 #GlennClose https://t.co/lOa1A8XH3N</tweet185>\n" +
                "<tweet186>Kindness still Trumps Evil. Thk u @jaketapper . For the 1st time in my life I can say  I wished I lived in Texas, I… https://t.co/XcBu9I3wKF</tweet186>\n" +
                "<tweet187>Have your own back before you can get anybody else’s. And just smile while you do it. #doyou #elzazagreda… https://t.co/hdB9ONqYs3</tweet187>\n" +
                "<tweet188>#womeninspire https://t.co/gv4I1sO1pY</tweet188>\n" +
                "<tweet189>What a sad day. Thank you for your graciousness BOTH times I met you in Europe. And most of all, I loved your charm… https://t.co/RyTTvfzGW9</tweet189>\n" +
                "<tweet190>Mood: Running into your Ex at brunch and he looks 9 months pregnant. Maybe you should put down that croissant \uD83E\uDD50 ?… https://t.co/LZCUnnJwqh</tweet190>\n" +
                "<tweet191>‘I believe in pink.\uD83C\uDF38. I believe that laughing is the best calorie burner.’ ~ Audrey Hepburn. #metoo… https://t.co/1oKm63abTQ</tweet191>\n" +
                "<tweet192>‘I believe in pink.\uD83C\uDF38. I believe that laughing is the best calorie burner.’ ~ Audrey Hepburn. #metoo #pinkpower… https://t.co/7ShLZ9vTGY</tweet192>\n" +
                "<tweet193>@tehsilentcircus @ray_gull @maggieNYT And they just keep getting away with it .</tweet193>\n" +
                "<tweet194>#womeninspire #WomenInWhite https://t.co/q7pHUs2Hve</tweet194>\n" +
                "<tweet195>@lety02 @Mimirocah1 @RVAwonk @RepAdamSchiff Maybe Anna Wintour could give @SpeakerPelosi the cover of Vogue instead… https://t.co/fXfTZjujrB</tweet195>\n" +
                "<tweet196>She paved the way for the other female Pres. hopefuls #truth @HillaryClinton https://t.co/CMz8X4I2lx</tweet196>\n" +
                "<tweet197>Painful . I was waiting for the Sound of Music to come on. #StateOfTheUnionAddress #lieslielies  @realDonaldTrump</tweet197>\n" +
                "<tweet198>Well it looks like I’ll be working from home, WOMEN can NEVER LEAVE THERE HOMES AGAIN ... M13 &amp; illegal aliens are… https://t.co/bWByErxgRw</tweet198>\n" +
                "<tweet199>Why 1st lady look like Cruella  @RogueFirstLady vear black &amp; standing ovation? Donnie no give her memo? #bebest… https://t.co/u3FNzSe9Gq</tweet199>\n" +
                "<tweet200>#womeninspire https://t.co/uvv2sQ5Btx</tweet200>";


        String returnXml = "<resultdescription>单据  16613dd7d9a00000000000000000000vouchergl0  开始处理...单据  16613dd7d9a00000000000000000000vouchergl0  处理完毕!"
                + "</resultdescription>"
                + "<content>2018.09-记账凭证-5</content>"
                + "<billpk></billpk><bdocid>16613dd7d9a00000000000000000000vouchergl0</bdocid>"
                + "<filename>vouchergld861102.xml</filename><resultcode>1</resultcode>"
                + "<resultdescription>单据  16613dd7d9a00000000000000000000vouchergl0  开始处理...单据  16613dd7d9a00000000000000000000vouchergl0  处理完毕!"
                + "</resultdescription>"
                + "<content1>2018.09-记账凭证-6</content></sendresult>";
        String regex = "<content>(.*?)</content>";
//        List<String> list = new ArrayList<String>();
//        List<String> extvounoLists = new ArrayList<String>();
//        Pattern pattern = Pattern.compile(regex);
//        Matcher m = pattern.matcher(returnXml);

        //<user1>1187567834437697536</user1>
        List<String> contentBetweenUsers = new ArrayList<>();
        Map<String, List<String>> mapTweets4AUser = new HashMap<>();

        List<String> usersAll = new ArrayList<>();
        String userRegex = "<user[0-9]+>(.*?)</user[0-9]+>";
        Pattern userPattern = Pattern.compile(userRegex);
        Matcher userMatcher = userPattern.matcher(content);
        while (userMatcher.find()) {
            System.out.println("=======");
            String userid = userMatcher.group(1);
            System.out.println(userid);
            usersAll.add(userid);
        }

//        String contentRegex = "<user\\d>(.*?)</tweet\\d>\\n<user\\d>";
//        Pattern contentPattern = Pattern.compile(contentRegex);
//        Matcher contentMatcher = contentPattern.matcher(content);


        //                "<tweet200>#womeninspire https://t.co/uvv2sQ5Btx</tweet200>";
        String tweetRegex = "<tweet[0-9]+>(.*?)</tweet[0-9]+>";
        Pattern tweetPattern = Pattern.compile(tweetRegex);
        Matcher tweetMatcher = tweetPattern.matcher(content);
//        while (contentMatcher.find()) {
//            int contentIdx=1;
//            System.out.println("_________________");
//            String contentInUsers = contentMatcher.group(contentIdx);
//            System.out.println(contentInUsers);
//            contentBetweenUsers.add(contentInUsers);
//            contentIdx++;
//        }
//        System.out.println("-----");
//        for (String str : usersAll) {
//            System.out.println(str);
//        }
        List<String> tweets = new ArrayList<>();
//
//        int x = 0;
//        while (tweetMatcher.find()) {
//            int j=1;
//            System.out.println("twetet-----------");
//            String tweetContent = tweetMatcher.group(j);
//            System.out.println(tweetContent);
//            tweets.add(tweetContent);
//            j++;
//            x++;
//
//        }
//        System.out.println(x);
//        mapTweets4AUser.put(userid, tweets);
//        while (m.find()) {
//            int i = 1;
//            list.add(m.group(i));
//            i++;
//        }
//        for (String str : list) {
//            System.out.println(str);
//            String[] strs = str.split("-");
//            String strss = strs[strs.length - 1];
//            extvounoLists.add(strs[strs.length - 1]);
//        }
//
//        for (String string : extvounoLists) {
//            System.out.println(string);
//        }
    }

}
