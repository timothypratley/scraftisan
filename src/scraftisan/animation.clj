(ns scraftisan.animation
  (:require [scraftisan.util :as util]
            [hiccup.element :refer [javascript-tag]]))

(def spider
  [:g {:id "spider-translate", :style "fill:#eeeeee; stroke: #000000; stroke-width: 1", :transform "translate(0.24258959,-0.24606636)"}
   (javascript-tag (slurp "scripts/animate-spider.js"))
   [:g {:id "spider-rotate", :transform "rotate(8.0403073,128.29552,-264.83472)"}
    [:g {:id "g3852"}
     [:g {:id "leg1a", :transform "rotate(-15,180.16726,141.723)"}
      [:g {:id "leg1b", :transform "rotate(-2.0369099,215.83101,142.643)"}
       [:g {:id "leg1c", :transform "rotate(-0.27565175,261.6683,138.47547)"}
        [:path {:id "path2860", :d "m 271.53906,139.97852 c 4.84182,-1.13833 15.9588,-4.10023 17.43946,-4.64649 0.44,-0.16232 2.09568,-0.75596 3.67968,-1.31836 1.584,-0.5624 3.48432,-1.2929 4.22266,-1.62305 0.73834,-0.33012 1.53814,-0.5996 1.77734,-0.5996 0.93421,0 3.35705,-1.86418 3.69922,-2.84571 0.4296,-1.23235 0.54949,-1.22584 -4.33594,-0.21679 -2.06955,0.42745 -6.49975,1.29834 -9.84375,1.93554 -16.55341,3.15423 -25.26364,5.03007 -27.5332,5.93164 -2.81483,2.86214 1.07235,6.09 10.89453,3.38282 z"}]]
       [:path {:id "path3974", :d "m 219.53906,146.08207 c 19.31093,-0.35331 28.68833,-1.4348 44.94604,-5.25703 2.37796,-1.84284 -0.11259,-5.50349 -3.84057,-4.2293 -2.76065,1.09665 -2.92938,1.13009 -2.37891,0.4668 0.22267,-0.26825 0.29921,-0.591 0.17188,-0.71875 -0.12732,-0.12774 -1.69461,-0.27944 -3.48438,-0.33594 -3.6784,-0.11621 -6.47466,0.4042 -13.55468,2.52149 -4.59081,1.37289 -5.02544,1.45728 -4.17578,0.8125 0.51661,-0.39203 0.47941,-0.44709 -0.43946,-0.63086 -2.34183,-0.46836 -5.06799,-0.21588 -7.09375,0.65625 -1.7362,0.74746 -2.52904,0.87458 -6.20117,0.99609 -3.61831,0.11974 -4.49513,0.0477 -6.24023,-0.51562 -3.57837,-0.65277 -7.17567,5.42318 2.29101,6.23437 z"}]]
      [:path {:id "path4761", :d "m 182.09766,144.99223 3.67968,-1.09961 7.68164,0.82812 c 13.85402,1.49357 13.09764,1.29511 24.01841,1.09531 3.52018,-0.47854 3.53473,-5.80543 -2.29101,-6.23437 -2.33716,-0.75447 -6.43346,-1.18109 -16.91099,-1.86875 -8.67068,-0.56906 -11.89435,-0.60104 -15.50391,-0.14844 -1.46857,0.18377 -2.7355,0.27036 -2.8164,0.18946 -3.03154,0.57174 -5.62889,7.58397 2.14258,7.23828 z"}]]
     [:g {:id "leg3a", :transform "rotate(-3.2266752,174.81984,135.31365)"}
      [:g {:id "leg3b", :transform "rotate(1.6210083,215.8489,114.2765)"}
       [:g {:id "leg3c", :transform "rotate(-5.3910951,244.31134,80.9288)"}
        [:path {:id "path5674", :d "m 251.82617,75.630899 c 12.82916,-17.29576 20.86817,-29.350589 20.08985,-30.128906 -0.42721,-0.427206 -7.61248,6.778814 -12.49219,12.529297 -2.76293,3.255959 -6.87549,8.360396 -16.6343,21.17836 -1.3041,7.228056 3.56731,5.154535 9.03664,-3.578751 z"}]]
       [:path {:id "path6236", :d "m 219.3418,114.99027 c 0.89951,-0.91804 2.42848,-2.25174 3.39648,-2.96289 4.30545,-3.16306 11.43145,-11.58754 19.08399,-22.560543 10.0039,-13.835938 4.95314,-18.746358 -8.32227,1.84375 -8.02145,10.535993 -12.38958,15.294573 -17.62695,19.207033 -3.52384,3.22037 -2.74347,8.4554 3.46875,4.47265 z"}]]
      [:path {:id "path7485", :d "m 178.93504,137.94411 c 0.66218,-0.74862 2.05215,-2.06446 3.28762,-2.7761 0.72303,-0.41647 2.79595,-1.35999 4.60546,-2.0957 1.80954,-0.73571 5.69816,-2.64201 8.64063,-4.23633 2.94248,-1.59433 5.99706,-3.18488 6.78906,-3.53516 0.792,-0.35028 1.80024,-0.88654 2.24024,-1.1914 0.44,-0.30487 2.95961,-1.67134 5.59961,-3.03711 5.65569,-2.92591 7.05215,-3.84485 9.24414,-6.08204 1.66982,-1.80629 -0.83018,-4.86255 -3.46875,-4.47265 -2.89651,2.16378 -5.58849,3.48894 -11.53516,5.67969 -11.87911,4.37625 -19.71349,8.01096 -30.35156,14.08007 -7.77393,4.03471 -1.54058,12.12664 4.94871,7.66673 z"}]]
     [:g {:id "leg5a", :transform "rotate(-4.953437,149.27215,141.58182)"}
      [:g {:id "leg5b", :transform "rotate(-4.3649059,141.48112,84.345304)"}
       [:g {:id "leg5c", :transform "rotate(-2.7328005,117.53013,45.182658)"}
        [:path {:id "path8417", :d "m 86.330078,16.572266 c -0.200069,0.03763 -0.232422,0.251226 -0.232422,0.560546 0,0.602027 11.059176,11.704179 17.281254,17.34961 7.64079,6.932675 12.05903,11.198841 13.40039,12.9375 2.87661,0.972248 3.7108,-2.752671 0.39648,-5.21871 -3.45228,-3.478067 -7.49184,-7.60425 -8.97656,-9.167969 -3.43845,-3.621426 -5.76578,-5.564158 -11.88672,-9.925781 -7.27167,-5.181602 -9.382216,-6.648039 -9.982422,-6.535156 z"}]]
       [:path {:id "path9003", :d "m 116.7793,47.419922 c 0.7419,0.961629 2.26876,3.477243 3.39258,5.589844 1.12381,2.112602 4.19401,7.274361 6.82226,11.470703 5.12393,8.181014 9.84947,16.326327 11.28906,19.457031 2.24005,4.444714 7.90885,2.925581 3.4668,-4.929648 -3.10289,-6.321751 -8.12924,-15.484107 -11.30273,-20.603515 -3.50493,-5.654079 -5.3674,-8.160483 -11.81004,-14.651254 -1.46145,-1.551871 -4.01622,1.226865 -1.85793,3.666839 z"}]]
      [:path {:id "path9304", :d "m 139.5332,90.990234 c 0.19854,2.816 0.48938,9.440706 0.64649,14.720706 0.29799,10.01513 0.58195,12.35135 2.39062,19.67968 0.41266,1.67201 0.93959,4.11946 1.16992,5.43946 -0.15483,23.80148 13.04209,12.53367 9.39454,7.35551 -0.99024,-1.95415 -1.40978,-4.00782 -2.875,-14.07422 -1.45778,-10.01539 -1.97216,-14.14699 -2.57422,-20.64063 -0.58333,-6.291718 -1.07621,-9.579016 -2.21875,-14.808591 -1.00777,-8.496485 -8.41008,-10.663002 -5.9336,2.328085 z"}]]
     [:path {:style "stroke: none" :id "path2571",:d "m 143.95312,141.5625 c -0.12301,0.12303 -0.85656,0.29356 -1.63085,0.38086 -14.70176,-1.40538 -4.22558,-0.47443 -27.74415,-4.01758 -0.73749,-0.23741 -2.14641,-0.0978 -5.85546,-0.41016 -10.33496,-0.87021 -15.467921,-0.3426 -25.023441,4.43555 -7.64873,3.82467 -11.720012,8.03866 -13.826172,14.31836 -0.77547,2.31226 -0.859747,3.02583 -0.873047,7.36133 -1e-4,0.0327 0.002,0.0399 0.002,0.0723 h 112.8437 c -0.72628,-6.42216 -1.2652,-8.73982 -1.42773,-14.63671 -1.16704,0.005 -2.22731,-1.07877 -2.09961,-2.14649 9.04131,-3.43921 4.08959,-8.50746 1.63672,-9.16601 2.17167,-4.26555 -4.27381,-8.0983 -7.37954,-6.44199 -3.44913,1.96775 -4.29188,2.00435 -5.63023,2.31308 -2.16174,0.49868 -3.24954,1.08435 -5.54883,2.98438 -1.28101,1.0586 -1.68971,1.23209 -2.53125,1.07421 -0.98627,-0.18502 -2.4256,0.38353 -4.1875,1.6543 -2.98635,-2.34344 -9.04464,-3.00654 -10.72461,2.22457 z"}]
     [:g {:id "leg7a", :transform "rotate(-8.4125966,140.76218,145.19544)"}
      [:g {:id "leg7b", :transform "rotate(6.880544,98.346206,130.16218)"}
       [:g {:id "leg7c", :transform "rotate(11.466922,63.886224,113.07719)"}
        [:path {:id "path9820", :d "M 64.349702,109.56203 C 56.376855,106.88101 57.593687,107.56835 44.498047,101 c -6.952,-3.486892 -13.576703,-6.853913 -14.720703,-7.482422 -2.63914,-1.449936 -5.079931,-2.430037 -5.462891,-2.193359 -0.65114,0.402429 -0.184512,1.039079 2.298828,3.138672 1.70714,1.443331 3.974382,2.90533 6.638672,4.28125 2.22553,1.149334 5.280513,2.778129 6.789063,3.619139 1.50854,0.84101 7.844628,4.12268 14.080078,7.29297 14.153658,7.94517 14.463957,2.11345 10.228608,-0.0942 z"}]]
       [:path {:id "path12181", :d "m 102.47461,123.4707 c -1.3456,0 -4.037959,-1.04674 -16.986329,-6.60742 -8.18197,-3.51374 -9.931634,-4.13537 -16.990234,-6.0293 -7.679313,-3.18287 -13.394579,1.12125 4.640625,7.62696 8.73178,3.45576 14.024314,5.86016 13.777344,6.25976 -0.09272,0.15003 1.937195,0.79936 4.509765,1.44336 4.67604,1.17056 4.677726,1.1716 6.072266,2.72266 5.946623,2.02173 9.208383,-3.10442 4.976563,-5.41602 z"}]]
      [:path {:id "path12670", :d "m 143.11011,143.639 c 0,0 -0.9945,-1.68318 -1.76879,-1.59588 -1.59147,-0.47044 -1.83904,-0.3423 -9.80226,-5.27359 -3.608,-2.23427 -8.4327,-4.9763 -10.7207,-6.09375 -8.04658,-3.92991 -16.38536,-7.20508 -18.34375,-7.20508 -2.19383,-0.67218 -6.016783,2.01389 -4.976563,5.41602 1.1166,1.24194 2.017904,1.81962 4.517573,2.89648 4.96666,2.13964 12.5625,5.85373 12.5625,6.14258 29.2418,16.15756 29.77806,8.86867 28.53199,5.71322 z"}]]
     [:g {:id "m1a", :transform "rotate(-5.4746575,179.16303,152.0992)"}
      [:path {:id "path14528", :d "m 180.81836,154.46098 c 0,-0.46482 2.43651,-0.75061 5.94922,-0.69532 3.93378,0.0619 7.30327,0.73807 11.5918,2.32227 4.11272,1.51925 6.45652,1.23836 5.96679,-0.71289 -0.30767,-1.22583 -3.08758,-4.14133 -4.87695,-5.11523 -2.00786,-1.09281 -8.56634,-2.46875 -11.76563,-2.46875 -1.42855,0 -3.11236,0.24448 -4.35742,0.63476 -1.11568,0.34973 -2.4242,0.63863 -2.9082,0.64063 -4.72797,0.44753 -3.74758,6.22628 0.40039,5.39453 z"}]]
     [:g {:id "m1b", :transform "rotate(-8.8975778,178.24317,156.97991)"}
      [:path {:id "path14726", :d "m 186.50977,161.87113 c 4.9465,0.96039 4.98534,0.94676 3.05078,-1.04101 -1.31526,-1.35147 -1.58305,-1.80547 -1.3711,-2.32031 0.1449,-0.352 0.27471,-0.79041 0.28711,-0.97461 0.0124,-0.18421 -1.70636,-0.8964 -3.81836,-1.58399 -2.112,-0.6876 -3.83984,-1.358 -3.83984,-1.49023 -6.96154,-0.12996 -8.36887,5.66572 5.69141,7.41015 z"}]]]
    [:g {:id "g15251", :transform "matrix(1,0,0,-1,0,326.12268)"}
     [:g {:id "leg2a", :transform "rotate(-15,180.16726,141.723)"}
      [:g {:id "leg2b", :transform "rotate(-2.0369099,215.83101,142.643)"}
       [:g {:id "leg2c", :transform "rotate(-0.27565175,261.6683,138.47547)"}
        [:path {:id "path15193", :d "m 271.53906,139.97852 c 4.84182,-1.13833 15.9588,-4.10023 17.43946,-4.64649 0.44,-0.16232 2.09568,-0.75596 3.67968,-1.31836 1.584,-0.5624 3.48432,-1.2929 4.22266,-1.62305 0.73834,-0.33012 1.53814,-0.5996 1.77734,-0.5996 0.93421,0 3.35705,-1.86418 3.69922,-2.84571 0.4296,-1.23235 0.54949,-1.22584 -4.33594,-0.21679 -2.06955,0.42745 -6.49975,1.29834 -9.84375,1.93554 -16.55341,3.15423 -25.26364,5.03007 -27.5332,5.93164 -2.81483,2.86214 1.07235,6.09 10.89453,3.38282 z"}]]
       [:path {:id "path15197", :d "m 219.53906,146.08207 c 19.31093,-0.35331 28.68833,-1.4348 44.94604,-5.25703 2.37796,-1.84284 -0.11259,-5.50349 -3.84057,-4.2293 -2.76065,1.09665 -2.92938,1.13009 -2.37891,0.4668 0.22267,-0.26825 0.29921,-0.591 0.17188,-0.71875 -0.12732,-0.12774 -1.69461,-0.27944 -3.48438,-0.33594 -3.6784,-0.11621 -6.47466,0.4042 -13.55468,2.52149 -4.59081,1.37289 -5.02544,1.45728 -4.17578,0.8125 0.51661,-0.39203 0.47941,-0.44709 -0.43946,-0.63086 -2.34183,-0.46836 -5.06799,-0.21588 -7.09375,0.65625 -1.7362,0.74746 -2.52904,0.87458 -6.20117,0.99609 -3.61831,0.11974 -4.49513,0.0477 -6.24023,-0.51562 -3.57837,-0.65277 -7.17567,5.42318 2.29101,6.23437 z"}]]
      [:path {:id "path15201", :d "m 182.09766,144.99223 3.67968,-1.09961 7.68164,0.82812 c 13.85402,1.49357 13.09764,1.29511 24.01841,1.09531 3.52018,-0.47854 3.53473,-5.80543 -2.29101,-6.23437 -2.33716,-0.75447 -6.43346,-1.18109 -16.91099,-1.86875 -8.67068,-0.56906 -11.89435,-0.60104 -15.50391,-0.14844 -1.46857,0.18377 -2.7355,0.27036 -2.8164,0.18946 -3.03154,0.57174 -5.62889,7.58397 2.14258,7.23828 z"}]]
     [:g {:id "leg4a", :transform "rotate(-3.2266752,174.81984,135.31365)"}
      [:g {:id "leg4b", :transform "rotate(1.6210083,215.8489,114.2765)"}
       [:g {:id "leg4c", :transform "rotate(-5.3910951,244.31134,80.9288)"}
        [:path {:id "path15205", :d "m 251.82617,75.630899 c 12.82916,-17.29576 20.86817,-29.350589 20.08985,-30.128906 -0.42721,-0.427206 -7.61248,6.778814 -12.49219,12.529297 -2.76293,3.255959 -6.87549,8.360396 -16.6343,21.17836 -1.3041,7.228056 3.56731,5.154535 9.03664,-3.578751 z"}]]
       [:path {:id "path15209", :d "m 219.3418,114.99027 c 0.89951,-0.91804 2.42848,-2.25174 3.39648,-2.96289 4.30545,-3.16306 11.43145,-11.58754 19.08399,-22.560543 10.0039,-13.835938 4.95314,-18.746358 -8.32227,1.84375 -8.02145,10.535993 -12.38958,15.294573 -17.62695,19.207033 -3.52384,3.22037 -2.74347,8.4554 3.46875,4.47265 z"}]]
      [:path {:id "path15213", :d "m 178.93504,137.94411 c 0.66218,-0.74862 2.05215,-2.06446 3.28762,-2.7761 0.72303,-0.41647 2.79595,-1.35999 4.60546,-2.0957 1.80954,-0.73571 5.69816,-2.64201 8.64063,-4.23633 2.94248,-1.59433 5.99706,-3.18488 6.78906,-3.53516 0.792,-0.35028 1.80024,-0.88654 2.24024,-1.1914 0.44,-0.30487 2.95961,-1.67134 5.59961,-3.03711 5.65569,-2.92591 7.05215,-3.84485 9.24414,-6.08204 1.66982,-1.80629 -0.83018,-4.86255 -3.46875,-4.47265 -2.89651,2.16378 -5.58849,3.48894 -11.53516,5.67969 -11.87911,4.37625 -19.71349,8.01096 -30.35156,14.08007 -7.77393,4.03471 -1.54058,12.12664 4.94871,7.66673 z"}]]
     [:g {:id "leg6a", :transform "rotate(-4.953437,149.27215,141.58182)"}
      [:g {:id "leg6b", :transform "rotate(-4.3649059,141.48112,84.345304)"}
       [:g {:id "leg6c", :transform "rotate(-2.7328005,117.53013,45.182658)"}
        [:path {:id "path15217", :d "m 86.330078,16.572266 c -0.200069,0.03763 -0.232422,0.251226 -0.232422,0.560546 0,0.602027 11.059176,11.704179 17.281254,17.34961 7.64079,6.932675 12.05903,11.198841 13.40039,12.9375 2.87661,0.972248 3.7108,-2.752671 0.39648,-5.21871 -3.45228,-3.478067 -7.49184,-7.60425 -8.97656,-9.167969 -3.43845,-3.621426 -5.76578,-5.564158 -11.88672,-9.925781 -7.27167,-5.181602 -9.382216,-6.648039 -9.982422,-6.535156 z"}]]
       [:path {:id "path15221", :d "m 116.7793,47.419922 c 0.7419,0.961629 2.26876,3.477243 3.39258,5.589844 1.12381,2.112602 4.19401,7.274361 6.82226,11.470703 5.12393,8.181014 9.84947,16.326327 11.28906,19.457031 2.24005,4.444714 7.90885,2.925581 3.4668,-4.929648 -3.10289,-6.321751 -8.12924,-15.484107 -11.30273,-20.603515 -3.50493,-5.654079 -5.3674,-8.160483 -11.81004,-14.651254 -1.46145,-1.551871 -4.01622,1.226865 -1.85793,3.666839 z"}]]
      [:path {:id "path15225", :d "m 139.5332,90.990234 c 0.19854,2.816 0.48938,9.440706 0.64649,14.720706 0.29799,10.01513 0.58195,12.35135 2.39062,19.67968 0.41266,1.67201 0.93959,4.11946 1.16992,5.43946 -0.15483,23.80148 13.04209,12.53367 9.39454,7.35551 -0.99024,-1.95415 -1.40978,-4.00782 -2.875,-14.07422 -1.45778,-10.01539 -1.97216,-14.14699 -2.57422,-20.64063 -0.58333,-6.291718 -1.07621,-9.579016 -2.21875,-14.808591 -1.00777,-8.496485 -8.41008,-10.663002 -5.9336,2.328085 z"}]]
     [:path {:style "stroke: none" :id "path15229", :d "m 143.95312,141.5625 c -0.12301,0.12303 -0.85656,0.29356 -1.63085,0.38086 -14.70176,-1.40538 -4.22558,-0.47443 -27.74415,-4.01758 -0.73749,-0.23741 -2.14641,-0.0978 -5.85546,-0.41016 -10.33496,-0.87021 -15.467921,-0.3426 -25.023441,4.43555 -7.64873,3.82467 -11.720012,8.03866 -13.826172,14.31836 -0.77547,2.31226 -0.859747,3.02583 -0.873047,7.36133 -1e-4,0.0327 0.002,0.0399 0.002,0.0723 h 112.8437 c -0.72628,-6.42216 -1.2652,-8.73982 -1.42773,-14.63671 -1.16704,0.005 -2.22731,-1.07877 -2.09961,-2.14649 9.04131,-3.43921 4.08959,-8.50746 1.63672,-9.16601 2.17167,-4.26555 -4.27381,-8.0983 -7.37954,-6.44199 -3.44913,1.96775 -4.29188,2.00435 -5.63023,2.31308 -2.16174,0.49868 -3.24954,1.08435 -5.54883,2.98438 -1.28101,1.0586 -1.68971,1.23209 -2.53125,1.07421 -0.98627,-0.18502 -2.4256,0.38353 -4.1875,1.6543 -2.98635,-2.34344 -9.04464,-3.00654 -10.72461,2.22457 z"}]
     [:g {:id "leg8a", :transform "rotate(-8.4125966,140.76218,145.19544)"}
      [:g {:id "leg8b", :transform "rotate(6.880544,98.346206,130.16218)"}
       [:g {:id "leg8c", :transform "rotate(11.466922,63.886224,113.07719)"}
        [:path {:id "path15231", :d "M 64.349702,109.56203 C 56.376855,106.88101 57.593687,107.56835 44.498047,101 c -6.952,-3.486892 -13.576703,-6.853913 -14.720703,-7.482422 -2.63914,-1.449936 -5.079931,-2.430037 -5.462891,-2.193359 -0.65114,0.402429 -0.184512,1.039079 2.298828,3.138672 1.70714,1.443331 3.974382,2.90533 6.638672,4.28125 2.22553,1.149334 5.280513,2.778129 6.789063,3.619139 1.50854,0.84101 7.844628,4.12268 14.080078,7.29297 14.153658,7.94517 14.463957,2.11345 10.228608,-0.0942 z"}]]
       [:path {:id "path15235", :d "m 102.47461,123.4707 c -1.3456,0 -4.037959,-1.04674 -16.986329,-6.60742 -8.18197,-3.51374 -9.931634,-4.13537 -16.990234,-6.0293 -7.679313,-3.18287 -13.394579,1.12125 4.640625,7.62696 8.73178,3.45576 14.024314,5.86016 13.777344,6.25976 -0.09272,0.15003 1.937195,0.79936 4.509765,1.44336 4.67604,1.17056 4.677726,1.1716 6.072266,2.72266 5.946623,2.02173 9.208383,-3.10442 4.976563,-5.41602 z"}]]
      [:path {:id "path15239", :d "m 143.11011,143.639 c 0,0 -0.9945,-1.68318 -1.76879,-1.59588 -1.59147,-0.47044 -1.83904,-0.3423 -9.80226,-5.27359 -3.608,-2.23427 -8.4327,-4.9763 -10.7207,-6.09375 -8.04658,-3.92991 -16.38536,-7.20508 -18.34375,-7.20508 -2.19383,-0.67218 -6.016783,2.01389 -4.976563,5.41602 1.1166,1.24194 2.017904,1.81962 4.517573,2.89648 4.96666,2.13964 12.5625,5.85373 12.5625,6.14258 29.2418,16.15756 29.77806,8.86867 28.53199,5.71322 z"}]]
     [:g {:id "m2a", :transform "rotate(-5.4746575,179.16303,152.0992)"}
      [:path {:id "path15243", :d "m 180.81836,154.46098 c 0,-0.46482 2.43651,-0.75061 5.94922,-0.69532 3.93378,0.0619 7.30327,0.73807 11.5918,2.32227 4.11272,1.51925 6.45652,1.23836 5.96679,-0.71289 -0.30767,-1.22583 -3.08758,-4.14133 -4.87695,-5.11523 -2.00786,-1.09281 -8.56634,-2.46875 -11.76563,-2.46875 -1.42855,0 -3.11236,0.24448 -4.35742,0.63476 -1.11568,0.34973 -2.4242,0.63863 -2.9082,0.64063 -4.72797,0.44753 -3.74758,6.22628 0.40039,5.39453 z"}]]
     [:g {:id "m2b", :transform "rotate(-8.8975778,178.24317,156.97991)"}
      [:path {:id "path15247", :d "m 186.50977,161.87113 c 4.9465,0.96039 4.98534,0.94676 3.05078,-1.04101 -1.31526,-1.35147 -1.58305,-1.80547 -1.3711,-2.32031 0.1449,-0.352 0.27471,-0.79041 0.28711,-0.97461 0.0124,-0.18421 -1.70636,-0.8964 -3.81836,-1.58399 -2.112,-0.6876 -3.83984,-1.358 -3.83984,-1.49023 -6.96154,-0.12996 -8.36887,5.66572 5.69141,7.41015 z"}]]]]])

(def slides
  (util/arrange "Animation"
                [spider 0 0]))
