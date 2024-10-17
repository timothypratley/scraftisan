(ns scraftisan.stars
  (:require [clojure.string :as str]
            [scicloj.kindly.v4.kind :as kind]
            [scraftisan.color :as color]
            [scraftisan.marcup :as marcup]))

(def constellations
  (array-map
    "Ursa Minor" [[0 0 1 "Polaris"]
                  [-3.5 -0.5 0.4]
                  [-7 1.5 0.5]
                  [-10.5 3.5 0.5]
                  [-13 3 0.4]
                  [-14.5 6.5 1]
                  [-11.5 6.5 1]]

    "Ursa Major" [[-18 24 1 "Mizar"]
                  [-15 21 1]
                  [-12 22 1]
                  [-7.5 22 0.5]
                  [-6.5 24.25 1]
                  [-0.75 22.5 1]
                  [-0.75 19.25 1]
                  [8.75 25.5 0.5]
                  [14 26.5 0.5]
                  [13 28 0.4]
                  [-5.25 28.25 0.4]
                  [-1.5 31.5 0.5]
                  [3.75 33.25 0.5]
                  [4.75 31.75 0.4]]

    ;; "Draco" [[]]
    ))

(def night-sky
  (into [:g {:data-title ""
             :transform  "translate(500,250) scale(5,5)"
             :fill       (color/palette 0)}
         (let [len 2.0
               l2 (/ len 2.0)
               w (/ len 10.0)
               -len (- len)
               -l2 (- l2)
               -w (- w)]
           [:g {:id   "north star"
                :fill (color/palette 0)
                #_#_:transform "translate(-30,-30) scale(1,1.2)"}
            [:path {:d (str/join " " ['M 0 -len 'L w 0 0 len -w 0 'Z])}]
            [:path {:d (str/join " " ['M -len 0 'L 0 w len 0 0 -w 'Z])}]
            [:path {:d (str/join " " ['M -l2 -l2 'L -w 0 l2 l2 w 0 'Z])}]
            [:path {:d (str/join " " ['M -l2 l2 'L -w 0 l2 -l2 w 0 'Z])}]])]
        (for [[cname stars] constellations
              [x y luminosity] stars]
          [:circle {:cx x :cy y :r (* luminosity 0.5)}])))

;; TODO: remove
(def night-sky-standalone
  (kind/hiccup
    [:svg {:height  "100%"
           :width   "100%"
           :viewBox [-127 -127 256 256]
           :xmlns   "http://www.w3.org/2000/svg"}
     [:rect {:fill   (color/palette 12)
             :stroke (color/palette 0)
             :x      -127
             :y      -127
             :width  256
             :height 256
             :rx     4}]
     night-sky]))

(def thematic
  [:g {:data-title ""}
   (marcup/md "a little bit of knowledge can take you a long way

to the stars!")])

(def saturn
  [:g {:data-title ""
       :transform  "translate(750,250) scale(0.01,0.01)"}
   [:g {:id "g2870"}
    [:path {:transform "matrix(0.757276,0.437214,-0.454310,0.786887,-286.1225,-691.8792)", :style "fill:#e7c278;fill-opacity:1.0000000;fill-rule:nonzero;stroke:none;stroke-width:0.31654838;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:4.0000000;stroke-dashoffset:0.0000000;stroke-opacity:1.0000000", :id "path2093", :d "M 1416.9885 589.88031 A 196.59508 172.42354 0 1 1  1023.7984,589.88031 A 196.59508 172.42354 0 1 1  1416.9885 589.88031 z"}]
    [:path {:d "M 202.71947,299.44658 C 208.38996,422.54373 348.39642,503.86621 459.39513,447.27144 C 365.21205,418.42218 272.86092,365.77250 202.71947,299.44658 z ", :id "path20317", :style "fill:url(#radialGradient2867);fill-opacity:1.0;fill-rule:evenodd;stroke:none;stroke-width:0.50000000;stroke-linecap:butt;stroke-linejoin:miter;stroke-miterlimit:4.0000000;stroke-opacity:1.0000000"}]
    [:path {:d "M 377.87820,147.06490 C 441.81993,156.53001 478.71921,187.73644 503.66094,219.70155 C 518.13363,237.67709 530.84601,264.79737 534.61925,287.64041 C 454.21914,272.64649 362.13235,223.37223 303.96474,154.15633 C 326.76049,146.78441 351.91070,143.53306 377.87820,147.06490 z ", :id "rect9686", :style "fill:url(#radialGradient2089);fill-opacity:1.0;fill-rule:nonzero;stroke:none;stroke-width:0.43750000;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:4.0000000;stroke-dashoffset:0.0000000;stroke-opacity:1.0000000"}]
    [:path {:d "M 376.79648,146.92869 C 411.72078,185.96055 460.54533,212.90035 505.45448,221.99848 C 468.61901,174.43424 423.93168,152.51279 376.79648,146.92869 z ", :id "path11205", :style "fill:url(#linearGradient2849);fill-opacity:1.0;fill-rule:evenodd;stroke:none;stroke-width:0.50000000;stroke-linecap:butt;stroke-linejoin:miter;stroke-miterlimit:4.0000000;stroke-opacity:1.0000000"}]
    [:path {:d "M 202.58476,285.35277 C 279.80473,357.10719 368.20139,411.04895 471.32596,440.47925 C 467.76379,443.04537 463.75773,444.98804 459.72414,447.09839 C 363.67074,418.14003 275.81952,367.48021 202.66126,298.86639 C 202.39134,293.29225 202.46298,290.33359 202.58476,285.35277 z ", :id "rect17282", :style "fill:url(#radialGradient2857);fill-opacity:1.0;fill-rule:nonzero;stroke:none;stroke-width:0.50000000;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:4.0000000;stroke-dashoffset:0.0000000;stroke-opacity:1.0000000"}]
    [:path {:d "M 248.88967,186.52076 C 315.86142,260.54075 446.02105,338.84748 534.01701,351.26923 C 533.42901,353.71899 532.78166,356.13448 532.13438,358.55002 C 443.47289,346.30658 310.77166,267.09499 243.41949,191.86009 C 245.22707,190.07119 247.01090,188.26856 248.88967,186.52076 z ", :id "rect12729", :style "fill:url(#radialGradient2834);fill-opacity:1.0;fill-rule:nonzero;stroke:none;stroke-width:0.50000000;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:4.0000000;stroke-dashoffset:0.0000000;stroke-opacity:1.0000000"}]]
   [:g {:id "g1346"}
    [:path {:transform "matrix(0.757276,0.437214,-0.454310,0.786887,-286.1225,-691.8792)", :style "fill:url(#radialGradient22276);fill-opacity:1.0000000;fill-rule:nonzero;stroke:none;stroke-width:0.31654838;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:4.0000000;stroke-dashoffset:0.0000000;stroke-opacity:1.0000000", :id "path8162", :d "M 1416.9885 589.88031 A 196.59508 172.42354 0 1 1  1023.7984,589.88031 A 196.59508 172.42354 0 1 1  1416.9885 589.88031 z"}]]
   [:g {:id "g16666", :transform "matrix(0.778907,0.449703,-0.449703,0.778907,-335.4228,-714.2288)"}
    [:path {:d "M 1073.3438,517.75000 C 918.35854,530.11674 809.50000,559.11597 809.50000,592.87500 C 809.50000,637.86332 1002.8104,674.37500 1241.0000,674.37500 C 1479.1896,674.37502 1672.5313,637.86329 1672.5312,592.87500 C 1672.5313,559.96071 1568.8269,531.64221 1420.0000,518.78125 C 1420.2794,519.35154 1420.4774,519.95785 1420.7500,520.53125 C 1564.0315,533.27743 1663.5312,560.71586 1663.5312,592.59375 C 1663.5313,636.59229 1474.4494,672.31250 1241.5000,672.31250 C 1008.5506,672.31252 819.50000,636.59230 819.50000,592.59375 C 819.50000,559.94909 923.67621,531.91227 1072.5312,519.59375 C 1072.8212,518.99033 1073.0469,518.34897 1073.3438,517.75000 z ", :id "path30933", :style "fill:#ada293;fill-opacity:1.0000000;fill-rule:nonzero;stroke:none;stroke-width:0.61603445;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:4.0000000;stroke-dashoffset:0.0000000;stroke-opacity:1.0000000"}]
    [:path {:d "M 1072.3125,520.06250 C 924.79567,532.36774 821.62500,560.19374 821.62500,592.59375 C 821.62500,636.37130 1009.7206,671.90625 1241.5000,671.90625 C 1473.2794,671.90627 1661.4062,636.37132 1661.4062,592.59375 C 1661.4062,560.95839 1562.9310,533.69553 1420.9688,520.96875 C 1422.3741,523.94787 1423.7491,526.93919 1424.9688,530.00000 C 1541.4522,542.21363 1620.4375,565.66378 1620.4375,592.59375 C 1620.4375,632.09871 1450.6583,664.15625 1241.5000,664.15625 C 1032.3417,664.15624 862.59375,632.09873 862.59375,592.59375 C 862.59376,564.88673 946.24963,540.89097 1068.2812,529.00000 C 1069.5143,525.95740 1070.9103,523.00455 1072.3125,520.06250 z ", :id "path31697", :style "fill:#ada393;fill-opacity:1.0000000;fill-rule:nonzero;stroke:none;stroke-width:0.61603445;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:4.0000000;stroke-dashoffset:0.0000000;stroke-opacity:1.0000000"}]
    [:path {:d "M 1061.3750,550.09375 C 995.39909,560.08148 953.03124,575.39329 953.03125,592.59375 C 953.03125,622.66954 1082.2643,647.06250 1241.5000,647.06250 C 1400.7357,647.06249 1530.0000,622.66956 1530.0000,592.59375 C 1530.0000,576.30670 1491.8907,561.73694 1431.8438,551.75000 C 1432.7971,555.71061 1433.6546,559.71376 1434.3125,563.78125 C 1467.5758,571.70795 1487.5938,581.70216 1487.5938,592.59375 C 1487.5937,618.24959 1377.3344,639.06250 1241.5000,639.06250 C 1105.6656,639.06249 995.43750,618.24961 995.43750,592.59375 C 995.43750,580.63725 1019.5911,569.77054 1058.9062,561.53125 C 1059.6010,557.67188 1060.4173,553.85099 1061.3750,550.09375 z ", :id "path31705", :style "fill:#343423;fill-opacity:0.72972971;fill-rule:nonzero;stroke:none;stroke-width:0.61603445;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:4.0000000;stroke-dashoffset:0.0000000;stroke-opacity:1.0000000"}]
    [:path {:d "M 1067.4375,530.84375 C 950.66132,542.62125 871.09377,565.85797 871.09375,592.59375 C 871.09375,631.21472 1037.0220,662.56250 1241.5000,662.56250 C 1445.9780,662.56249 1611.9374,631.21474 1611.9375,592.59375 C 1611.9375,566.65949 1536.9243,544.05341 1425.8438,531.96875 C 1428.2995,538.38194 1430.2202,545.00525 1431.8438,551.75000 C 1491.8907,561.73695 1530.0000,576.30672 1530.0000,592.59375 C 1530.0001,622.66954 1400.7357,647.06250 1241.5000,647.06250 C 1082.2643,647.06249 953.03125,622.66956 953.03125,592.59375 C 953.03124,575.39328 995.39909,560.08147 1061.3750,550.09375 C 1063.0514,543.51702 1065.0080,537.05888 1067.4375,530.84375 z ", :id "path31701", :style "fill:#d8d4c1;fill-opacity:1.0000000;fill-rule:nonzero;stroke:none;stroke-width:0.61603445;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:4.0000000;stroke-dashoffset:0.0000000;stroke-opacity:1.0000000"}]]])

(def flying-saucer
  [:g {:transform "translate(750,400)"}
   [:path {:fill "#1d1d1b" :d "m60.78 35.68c0-6.31.15-21.22-.16-25.94s-3.19-5.06-4.78-5.12-9.41-.31-17.16-.44-19.68-.78-24.75-.53-6.93 1.13-8.93 2.66-1.88 5.4-1.94 7.4c0 0-.06 8.82-.06 16.47s.37 23 .37 25.94.94 3.22 1.25 3.31a44 44 0 0 0 4.59.16c.32-.06 4.13-6.31 7.44-11.69s12.63-19.34 13.94-21 3.72-4.69 4.75-4.56.62 1.53.62 2.12-1.37 11.19-2.5 16.54-4.31 17.31-4.25 18.4 1 1 2.16 1 5.84 0 10.53-.09 8.44-.19 12-.5 6.53-1.41 6.94-2.88-.06-14.93-.06-21.25zm-30.85 9.38c-.15-.32-1.78.15-2.06.31s-.16 3.25-.16 3.25a12.29 12.29 0 0 0 -2.28-.75 3.41 3.41 0 0 0 -2.15.28 3.77 3.77 0 0 0 0-.53 1.25 1.25 0 0 0 -.25-.66 3.56 3.56 0 0 0 .56-.47 1.78 1.78 0 0 0 .47-1.18c0-.19-.09-.25-.31-.25s-.53.68-.72.81a1.64 1.64 0 0 1 -1.16.44 4.35 4.35 0 0 1 -1.47-.07s-.28-1.09-.37-1.37-.47-.13-.69 0 .34 1.84.34 1.84a2 2 0 0 0 -.37 2.16 2.24 2.24 0 0 0 1.37 1.31 2.55 2.55 0 0 0 .16 1.19 1.32 1.32 0 0 0 1 1 14.28 14.28 0 0 0 .1 2.53c.15.28.56.16.71.12a12.31 12.31 0 0 0 0-2.43l.41.06s.16 1.81.22 2.09.5.25.69.16a8.31 8.31 0 0 0 -.07-2.13 4.63 4.63 0 0 0 1.16 0c.5-.09 1-.22 1-.22s.06 2.22.09 2.38.6.12.82 0a10.55 10.55 0 0 0 .06-2.56l.47-.37s.09 1.94.12 2.13.44 0 .59-.19a11.07 11.07 0 0 0 0-2.28l.25-.44a10.67 10.67 0 0 0 .15-2.53c.06-.62.16-2.16.22-2.28a7 7 0 0 1 1.17-.57c.18-.1.09-.47-.07-.78z"}]
   #_[:path {:fill "#1f4863" :d "m7 7.24c1.3-1 3.68-1.71 7-2s16.37.47 22.56.72 16.31.41 18.34.47 3.94.94 4.1 3.75.15 13.85.15 19.75-.06 19.41-.09 22.28 0 3.66-1.22 4.57-6.25 1.59-11.19 1.68-10.62.16-12.5.16-2.78.09-2.84-.06 2.72-11.22 3.84-18 2.31-13.5 2.31-13.5a13.77 13.77 0 0 0 3.19 1c1.6.25 3.69-.25 4.44-1.91s.16-4.37-.09-5a7.41 7.41 0 0 0 -.82-1.37 8.67 8.67 0 0 0 .41-1.91 6.6 6.6 0 0 0 -.22-1.69 1.7 1.7 0 0 1 .81-.37 5.88 5.88 0 0 1 1.57 0 3.82 3.82 0 0 0 1.06 1.19c.53.28 2-.12 2.5-2a1.76 1.76 0 0 0 -1.53-2.46 3 3 0 0 0 -1.78 1.17 4.5 4.5 0 0 0 -.44 1 9.53 9.53 0 0 0 -1.47.06 10.06 10.06 0 0 0 -1.19.41 4.32 4.32 0 0 0 -1.68-2.28 4.55 4.55 0 0 0 -2.79-.9l-.87-1.87a1.55 1.55 0 0 0 .75-1.88c-.47-1.25-1.31-1.69-2.81-1.1a1.6 1.6 0 0 0 -.41 2.85 3.07 3.07 0 0 0 1.62.44l.44 1.5a2.18 2.18 0 0 0 -1.5.41 3.66 3.66 0 0 0 -.94.9 8.51 8.51 0 0 0 -4.12-.25 4 4 0 0 0 -3.53 4.25 8.33 8.33 0 0 0 2 4.59 9.93 9.93 0 0 0 1 1.16 76.53 76.53 0 0 0 -5.63 8.06c-3 4.84-8.78 14.12-10.78 17.34s-6 9.44-6.22 9.5a6.84 6.84 0 0 1 -2.81-.12c-.47-.35-.47-5.72-.4-8.78s-.38-21.44-.44-27.72-.88-11.6 2.22-14.04z"}]
   #_[:path {:fill "#1d1d1b" :d "m13.78 19.53c.56 0 1.47 0 1 .93s-2.1 2.57-.72 5.32 2 2.84 2.66 3 1.34-.09 1.5.22.31.5 0 .78a6.57 6.57 0 0 1 -7.57-.78c-3.37-3-2.09-6.09-.56-7.62a6 6 0 0 1 3.69-1.85z"}]
   #_[:path {:fill "#cbe7f5" :d "m12.84 20.84c.41-.16.31.34.22.53a4.51 4.51 0 0 0 0 4.91c1.56 2.81 1.66 2.78 1.62 2.9a3.91 3.91 0 0 1 -4.12-1.94c-1.5-2.4-.75-5.24 2.28-6.4z"}]
   #_[:path {:fill "#1d1d1b" :d "m22.5 20.34c1.57-.32 2.62.87 2 2.62s-2 2-3.13 1a2.14 2.14 0 0 1 1.13-3.62z"}]
   #_[:path {:fill "#ffe19b" :d "m22.59 21.26c.88-.18 1.46.49 1.12 1.47s-1.1 1.13-1.75.55a1.19 1.19 0 0 1 .63-2.02z"}]
   #_[:path {:fill "#1d1d1b" :d "m52.94 16.58c1.26-.26 2.09.69 1.6 2.09s-1.57 1.61-2.49.79a1.7 1.7 0 0 1 .89-2.88z"}]
   #_[:path {:fill "#ffe19b" :d "m53 17.31c.7-.14 1.17.39.89 1.17s-.88.9-1.39.44a1 1 0 0 1 .5-1.61z"}]
   #_[:path {:d "m12.06 35.68c1-.49 2.81-.34 2.28 1.94s-2.75 2.41-3.28 1.5a2.41 2.41 0 0 1 1-3.44z" :fill "#1d1d1b"}]
   [:path {:fill "#ffe19b" :d "m12.28 36.5c.58-.28 1.58-.19 1.29 1.09s-1.55 1.35-1.85.84a1.35 1.35 0 0 1 .56-1.93z"}]
   [:path {:fill "#e6e4da" :d "m15.71 12.78s-.5-.94-.34-1a1.41 1.41 0 0 1 .66-.21 7.48 7.48 0 0 1 .47 1.43h.31s.22-.81.44-.84.53 0 .46.19-.31.78-.31.78 1.06-.19 1.13 0 .28.62 0 .65l-1.1.13a.61.61 0 0 1 -.06.56 1 1 0 0 1 -.34.31s.47 1.1.22 1.29a1.38 1.38 0 0 1 -.6.21l-.34-1.4s-.91 1.09-1.16 1-.75-.47-.62-.56 1-1 1-1a6.39 6.39 0 0 1 -1.32.06c0-.1-.15-.56 0-.63s.75-.25.75-.25-.65-.15-.65-.31.34-.84.46-.75a9.94 9.94 0 0 0 .94.34z"}]
   #_[:path {:fill "#e6e4da" :d "m24.06 10.28s-.16-.57.19-.6.9 0 .9-.12-.28-1.35-.06-1.47.66-.25.62-.06.1 1.34.1 1.34.81-.66 1-.53a1.08 1.08 0 0 1 .25.4l-.88.69a5.55 5.55 0 0 1 1.22.28c0 .1.19.53-.22.53h-1.09a5 5 0 0 0 .37.85c.19.28.41.44.25.56s-.78.34-.84.25-.37-.91-.47-1.09-.22-.41-.22-.41-.59.63-.65.59-.57-.46-.44-.56l.56-.4z"}]
   [:g {:fill "#8ec480"}
    [:path {:d "m37.31 7.81c.88-.18 1.31.4 1.28.84s-1.22 1.06-1.69.72-.81-1.31.41-1.56z"}]
    [:path {:d "m37 13.59c.1-.13.63-.72 2.69-.31s3 1.09 3.56 2.46a4 4 0 0 1 .07 2.63 18.49 18.49 0 0 0 -3.16-2.84 15.27 15.27 0 0 0 -3.16-1.94z"}]
    [:path {:d "m48.56 13.59c.74-.33 1.06.81.84 1.56a1.09 1.09 0 0 1 -1.59.66c-.5-.35-.6-1.63.75-2.22z"}]]
   [:path {:fill "#1d1d1b" :d "m44.9 8.59a1.56 1.56 0 0 1 2.44 1.15c.12 1.54-2.09 1.72-2.69.82s-.53-1.38.25-1.97z"}]
   #_[:path {:fill "#ffe19b" :d "m45.43 9.25a.64.64 0 0 1 1 .48c0 .62-.86.7-1.1.33s-.22-.56.1-.81z"}]
   #_[:path {:d "m50.31 25.43c.12 0 1.34.13 1.37 0s.07-1.65.41-1.65.69 0 .62.18a4 4 0 0 0 -.15 1.28c.09 0 1.19-1.06 1.37-1s.57.21.47.37-1.65 1.56-1.65 1.56a11.24 11.24 0 0 1 .12 2.1c-.12 0-.66.22-.75 0a13.11 13.11 0 0 1 -.19-1.57s-.81 1.16-1 1-.56-.62-.4-.71.87-.75.87-.75l-1.12-.19z" :fill "#e6e4da"}]
   [:path {:fill "#1d1d1b" :d "m40.87 30.15a1.25 1.25 0 0 1 1.88 1.41 1.33 1.33 0 0 1 -2.41.56 1.59 1.59 0 0 1 .53-1.97z"}]
   [:path {:fill "#ffe19b" :d "m41.22 30.83a.52.52 0 0 1 .79.59.56.56 0 0 1 -1 .24.69.69 0 0 1 .21-.83z"}]
   [:path {:fill "#1d1d1b" :d "m40.93 45.68a1.25 1.25 0 0 1 1.88 1.41 1.33 1.33 0 0 1 -2.41.56 1.6 1.6 0 0 1 .53-1.97z"}]
   [:path {:fill "#ffe19b" :d "m41.28 46.36a.52.52 0 0 1 .79.59.56.56 0 0 1 -1 .24.67.67 0 0 1 .21-.83z"}]
   [:path {:fill "#1d1d1b" :d "m51.37 41a1.24 1.24 0 0 1 1.88 1.4 1.33 1.33 0 0 1 -2.41.56 1.58 1.58 0 0 1 .53-1.96z"}]
   [:path {:fill "#ffe19b" :d "m51.72 41.7a.53.53 0 0 1 .79.6.56.56 0 0 1 -1 .23.69.69 0 0 1 .21-.83z"}]
   [:path {:fill "#1d1d1b" :d "m51.5 51.15a1.24 1.24 0 0 1 1.87 1.41 1.33 1.33 0 0 1 -2.41.56 1.6 1.6 0 0 1 .54-1.97z"}]
   [:path {:fill "#ffe19b" :d "m51.84 51.83a.53.53 0 0 1 .8.59.56.56 0 0 1 -1 .24.67.67 0 0 1 .2-.83z"}]
   [:path {:d "m45 36.18s-.38-.9-.19-1.06.47-.31.53-.16.44 1.25.44 1.25.37-.75.53-.75.62 0 .59.16a4.85 4.85 0 0 1 -.4.75s1.09.16 1.09.31a3 3 0 0 1 -.16.6l-1.22.12s.72 1.78.57 1.91-.6.28-.66.18a14.63 14.63 0 0 0 -.5-1.5c-.09 0-.91 1.57-1.06 1.47s-.66-.28-.56-.4.75-.82.62-.91-.78-.06-.81-.28 0-.66.12-.69.72-.09.72-.09-.78-.38-.72-.53-.06-.6.32-.5a5.44 5.44 0 0 0 .75.12z" :fill "#e6e4da"}]
   [:path {:d "m39.37 51.18s.28-.31.44-.25a6.2 6.2 0 0 1 .72 1.1s.25-.69.43-.63.41 0 .35.16-.31 1.31-.31 1.31 1.47.44 1.47.72 0 .53-.1.53-.84-.13-.84-.13.15.6 0 .66l-.25.09-.81-.93s-.41 1.28-.57 1.25l-.78-.13.06-.69s-.4 0-.5-.28-.25-1.15 0-1.18 1.25 0 1.22-.1-.5-1.28-.53-1.5z" :fill "#e6e4da"}]
   [:path {:d "m20.71 47.28c.45-.08 1.47-.29 1.69.15a.91.91 0 0 1 -.25 1.31 2.1 2.1 0 0 1 -1.87.13c-.16-.19-.85-1.38.43-1.59z" :fill "#f2910d"}]
   [:path {:d "m22 49.81a5.19 5.19 0 0 1 3.22-1.13c1.53.13 2.07.63 2.22 1.13a1.23 1.23 0 0 1 -.56 1.59 5.1 5.1 0 0 1 -3.66.25c-1.72-.37-1.79-1.31-1.22-1.84z" :fill "#f2910d"}]
   [:path {:d "m31.84 21.9c-.06-.12-2.59-2.72-2.41-4.62s.6-4 4.63-3 6.75 2.71 8.5 5.21 1.9 4.5 1.72 5.16a4.75 4.75 0 0 1 -.35.94s-2.18-3.88-2.34-3.88-.78.41-.63.57 2.79 4.06 2.57 4.15-.69.28-.69.28-2.19-3.87-2.38-3.93-.75.18-.62.31 2.34 3.72 2.25 3.75a7.25 7.25 0 0 1 -.81 0l-1.91-3.13s-.5.16-.44.28 1.69 2.91 1.57 2.91-1.57-.56-1.79-.66l-1.15-.5s.75-3.21.09-4.12-.78-1.69-2.56-1.47a6.33 6.33 0 0 0 -3.25 1.75z" :fill "#c8db89"}]
   [:path {:fill "#1d1d1b" :d "m30.56 17a1.58 1.58 0 0 1 1.06-1.22c.94-.32 1.41-.07 1.53.25s.22.62-.12.68-.94-.25-1.38.22-.15.66-.53.66-.47-.47-.56-.59z"}]])

(def satellite
  [:g {:data-title ""
       :transform "translate(750,100) scale(0.2,0.2)"}
   [:g
    [:path {:style "fill:#EAEEEF;", :d "M261.083,238.296l-22.768,22.768l-13.457-13.457l22.768-22.768L261.083,238.296z"}]
    [:path {:style "fill:#EAEEEF;", :d "M212.094,189.338l-22.768,22.768L175.54,198.32l22.768-22.768L212.094,189.338z"}]
    [:path {:style "fill:#EAEEEF;", :d "M104.501,81.748l-22.768,22.737L68.31,91.059l22.738-22.768L104.501,81.748z"}]
    [:path {:style "fill:#EAEEEF;", :d "M55.544,32.758L32.777,55.526L18.99,41.74l22.768-22.768L55.544,32.758z"}]
    [:path {:style "fill:#EAEEEF;", :d "M244.563,38.736c-0.811,0.781-2.103,0.781-2.883,0c-0.811-0.811-0.811-2.103,0-2.883 c0.39-0.421,0.901-0.601,1.442-0.601c0.511,0,1.021,0.18,1.442,0.601C245.343,36.633,245.343,37.925,244.563,38.736z"}]
    [:path {:style "fill:#C5CBCF;", :d "M198.158,41.859l40.369,40.369c-5.316,5.016-12.255,7.779-19.584,7.779 c-7.629,0-14.808-2.974-20.184-8.35c-0.03,0-0.03,0-0.03,0c-5.377-5.407-8.35-12.585-8.35-20.214 C190.376,54.114,193.139,47.176,198.158,41.859z"}]
    [:path {:style "fill:#EAEEEF;", :d "M210.932,79.997c6.851,0,13.342-2.442,18.505-6.854l-31.28-31.283 c-5.016,5.316-7.779,12.255-7.779,19.584c0,4.361,1,8.56,2.838,12.378C198.231,77.81,204.41,79.997,210.932,79.997z"}]
    [:path {:style "fill:#505967;", :d "M66.655,43.872l13.276,13.306L57.165,79.915L43.89,66.639L66.655,43.872z"}]
    [:path {:style "fill:#505967;", :d "M165.177,77.543l37.666,37.695l-6.491,6.488L158.656,84.06L165.177,77.543z"}]
    [:path {:style "fill:#505967;", :d "M116.549,201.533l-7.419,7.389l-37.669-37.666l7.392-7.389L116.549,201.533z"}]
    [:path {:style "fill:#505967;", :d "M236.514,213.727l-22.768,22.768l-13.276-13.276l22.768-22.768L236.514,213.727z"}]
    [:path {:style "fill:#EAEEEF;", :d "M185.21,132.84l-57.55,57.579l-37.666-37.695l57.553-57.55L185.21,132.84z"}]
    [:path {:style "fill:#2D213F;", :d "M277.754,232.74c3.064,3.064,3.064,8.05,0,11.113l-33.881,33.881 \t\tc-1.532,1.562-3.544,2.313-5.557,2.313c-2.012,0-4.025-0.751-5.557-2.313l-73.889-73.859c-1.472-1.472-2.313-3.484-2.313-5.557 \t\tc0-2.103,0.841-4.085,2.313-5.557l11.053-11.053l-5.647-5.647l-49.59,49.56c-1.532,1.532-3.544,2.283-5.557,2.283 \t\ts-4.025-0.751-5.557-2.283l-48.809-48.809c-3.064-3.064-3.064-8.05,0-11.113l49.59-49.56l-6.007-6.007l-11.053,11.053 \t\tc-1.532,1.532-3.544,2.313-5.557,2.313s-4.025-0.781-5.557-2.313L2.321,47.296c-3.094-3.064-3.094-8.05,0-11.113l33.88-33.881 \t\tc3.064-3.064,8.05-3.064,11.113,0l73.889,73.859c3.064,3.094,3.064,8.05,0,11.143L109.46,99.019l6.007,5.977l44.153-44.123 \t\tc3.064-3.064,8.05-3.064,11.113,0l4.085,4.085c-0.09-1.171-0.18-2.313-0.18-3.514c0-11.804,4.626-22.948,12.976-31.298 \t\tl4.986-4.986c2.944-2.944,8.17-2.944,11.113,0l20.184,20.214l2.433-2.433c-2.073-6.218-0.721-13.306,4.205-18.232 \t\tc6.938-6.908,18.202-6.908,25.14,0c3.454,3.484,5.196,8.02,5.196,12.555c0,4.566-1.742,9.131-5.196,12.585 \t\tc-3.454,3.454-8.02,5.196-12.555,5.196c-1.922,0-3.815-0.39-5.647-0.991l-2.433,2.433l20.184,20.184 \t\tc1.472,1.472,2.313,3.484,2.313,5.557c0,2.103-0.841,4.115-2.313,5.587l-4.986,4.956c-8.35,8.38-19.464,12.976-31.298,12.976 \t\tc-1.171,0-2.343-0.09-3.514-0.18l4.085,4.085c3.094,3.094,3.094,8.05,0,11.143l-44.123,44.123l5.647,5.677l11.714-11.744 \t\tc1.472-1.472,3.484-2.283,5.557-2.283c2.103,0,4.085,0.811,5.587,2.283L277.754,232.74z M238.313,261.065l22.768-22.768 \t\tl-13.456-13.456l-22.768,22.768L238.313,261.065z M244.563,38.736c0.781-0.811,0.781-2.103,0-2.883 \t\tc-0.421-0.421-0.931-0.601-1.442-0.601c-0.541,0-1.051,0.18-1.442,0.601c-0.811,0.781-0.811,2.073,0,2.883 \t\tC242.462,39.517,243.748,39.517,244.563,38.736z M238.522,82.228l-40.369-40.369c-5.016,5.316-7.779,12.255-7.779,19.584 \t\tc0,7.629,2.974,14.808,8.35,20.214c0,0,0,0,0.03,0c5.377,5.377,12.555,8.35,20.184,8.35 \t\tC226.268,90.008,233.21,87.244,238.522,82.228z M213.742,236.495l22.768-22.768l-13.276-13.276l-22.768,22.768L213.742,236.495z \t\t M189.326,212.105l22.768-22.768l-13.787-13.787l-22.768,22.768L189.326,212.105z M202.843,115.238l-37.666-37.696l-6.518,6.518 \t\tl37.696,37.666L202.843,115.238z M127.66,190.419l57.55-57.58l-37.666-37.666l-57.55,57.55L127.66,190.419z M109.13,208.922 \t\tl7.419-7.389l-37.696-37.666l-7.389,7.389L109.13,208.922z M81.733,104.485l22.768-22.738L91.045,68.291L68.307,91.059 \t\tL81.733,104.485z M79.931,57.178L66.655,43.872L43.889,66.639l13.276,13.276L79.931,57.178z M32.778,55.526l22.768-22.768 \t\tL41.757,18.972L18.99,41.739L32.778,55.526z"}]]
   [:path {:style "fill:#454D5B;", :d "M175.042,100.43l21.314,21.296l6.488-6.488l-23.828-23.846 C177.91,94.078,176.591,97.102,175.042,100.43z"}]
   [:path {:style "fill:#454D5B;", :d "M109.13,208.922l7.419-7.389l-12.759-12.747c-2.802,2.082-5.707,4.115-8.69,6.109L109.13,208.922z"}]
   [:path {:style "fill:#C5CBCF;", :d "M116.134,178.885l11.525,11.534l57.55-57.58l-17.682-17.682 C156.964,134.221,140.49,157.842,116.134,178.885z"}]])

(def earth
  [:g {:data-title ""}
   ;; ocean
   [:circle {:cx   500
             :cy   5470
             :r    5000
             :fill (color/palette 3)}]
   ;; land
   [:g {:fill      (color/palette 1)
        :transform "translate (-4510,470) scale(206,206)"}
    [:polygon {:points "35.432,10.815 35.479,11.176 34.938,11.288 34.866,12.057 35.514,12.057 36.376,11.974 36.821,11.445
			36.348,11.261 36.089,10.963 35.7,10.333 35.514,9.442 34.783,9.591 34.578,9.905 34.578,10.259 34.93,10.5"}]
    [:polygon {:points "34.809,11.111 34.848,10.629 34.419,10.444 33.819,10.583 33.374,11.297 33.374,11.76 33.893,11.76"}]
    [:path {:d "M22.459,13.158l-0.132,0.34h-0.639v0.33h0.152c0,0,0.009,0.07,0.022,0.162l0.392-0.033l0.245-0.152l0.064-0.307
			l0.317-0.027l0.125-0.258l-0.291-0.06L22.459,13.158z"}]
    [:polygon {:points "20.812,13.757 20.787,14.08 21.25,14.041 21.298,13.717 21.02,13.498"}]
    [:path {:d "M48.619,24.061c-0.007-0.711-0.043-1.417-0.11-2.112c-0.225-2.317-0.779-4.538-1.609-6.62
			c-0.062-0.155-0.119-0.312-0.185-0.465c-1.106-2.613-2.659-4.992-4.56-7.045c-0.125-0.134-0.252-0.266-0.379-0.396
			c-0.359-0.373-0.728-0.737-1.11-1.086C36.344,2.402,30.604,0,24.312,0C17.967,0,12.186,2.445,7.852,6.44
			C6.842,7.371,5.914,8.387,5.072,9.475C1.896,13.583,0,18.729,0,24.312c0,13.407,10.907,24.313,24.313,24.313
			c9.43,0,17.617-5.4,21.647-13.268c0.862-1.682,1.533-3.475,1.985-5.354c0.115-0.477,0.214-0.956,0.3-1.441
			c0.245-1.381,0.379-2.801,0.379-4.25C48.625,24.228,48.62,24.145,48.619,24.061z M44.043,14.344l0.141-0.158
			c0.185,0.359,0.358,0.724,0.523,1.094l-0.23-0.009l-0.434,0.06V14.344z M40.53,10.102l0.004-1.086
			c0.382,0.405,0.75,0.822,1.102,1.254l-0.438,0.652l-1.531-0.014l-0.096-0.319L40.53,10.102z M11.202,7.403V7.362h0.487
			l0.042-0.167h0.797v0.348l-0.229,0.306h-1.098L11.202,7.403L11.202,7.403z M11.98,8.488c0,0,0.487-0.083,0.529-0.083
			s0,0.486,0,0.486L11.411,8.96l-0.209-0.25L11.98,8.488z M45.592,18.139h-1.779l-1.084-0.807l-1.141,0.111v0.696h-0.361
			l-0.39-0.278l-1.976-0.501v-1.28l-2.504,0.195l-0.776,0.417h-0.994L34.1,16.643l-1.207,0.67v1.261l-2.467,1.78l0.205,0.76h0.5
			L31,21.838l-0.352,0.129l-0.019,1.892l2.132,2.428h0.928l0.056-0.148h1.668l0.481-0.445h0.946l0.519,0.52l1.41,0.146l-0.187,1.875
			l1.565,2.763l-0.824,1.575l0.056,0.742l0.649,0.647v1.784l0.852,1.146v1.482h0.736c-4.096,5.029-10.33,8.25-17.305,8.25
			C12.009,46.625,2,36.615,2,24.312c0-3.097,0.636-6.049,1.781-8.732v-0.696l0.798-0.969c0.277-0.523,0.574-1.033,0.891-1.53
			l0.036,0.405l-0.926,1.125c-0.287,0.542-0.555,1.096-0.798,1.665v1.27l0.927,0.446v1.765l0.889,1.517l0.723,0.111l0.093-0.52
			l-0.853-1.316l-0.167-1.279h0.5l0.211,1.316l1.233,1.799L7.02,21.27l0.784,1.199l1.947,0.482v-0.315l0.779,0.111l-0.074,0.556
			l0.612,0.112l0.945,0.258l1.335,1.521l1.705,0.129l0.167,1.391l-1.167,0.816l-0.055,1.242l-0.167,0.76l1.688,2.113l0.129,0.724
			c0,0,0.612,0.166,0.687,0.166c0.074,0,1.372,0.983,1.372,0.983v3.819l0.463,0.13l-0.315,1.762l0.779,1.039l-0.144,1.746
			l1.029,1.809l1.321,1.154l1.328,0.024l0.13-0.427l-0.976-0.822l0.056-0.408l0.175-0.5l0.037-0.51l-0.66-0.02l-0.333-0.418
			l0.548-0.527l0.074-0.398l-0.612-0.175l0.036-0.37l0.872-0.132l1.326-0.637l0.445-0.816l1.391-1.78l-0.316-1.392l0.427-0.741
			l1.279,0.039l0.861-0.682l0.278-2.686l0.955-1.213l0.167-0.779l-0.871-0.279l-0.575-0.943l-1.965-0.02l-1.558-0.594l-0.074-1.111
			l-0.52-0.909l-1.409-0.021l-0.814-1.278l-0.723-0.353l-0.037,0.39l-1.316,0.078l-0.482-0.671l-1.373-0.279l-1.131,1.307
			l-1.78-0.302l-0.129-2.006l-1.299-0.222l0.521-0.984l-0.149-0.565l-1.707,1.141l-1.074-0.131L9.48,21.016l0.234-0.865l0.592-1.091
			l1.363-0.69l2.632-0.001l-0.007,0.803l0.946,0.44l-0.075-1.372l0.682-0.686l1.376-0.904l0.094-0.636l1.372-1.428l1.459-0.808
			l-0.129-0.106l0.988-0.93l0.362,0.096l0.166,0.208l0.375-0.416l0.092-0.041l-0.411-0.058l-0.417-0.139v-0.4l0.221-0.181h0.487
			l0.223,0.098l0.193,0.39l0.236-0.036v-0.034l0.068,0.023l0.684-0.105l0.097-0.334l0.39,0.098v0.362l-0.362,0.249h0.001
			l0.053,0.397l1.239,0.382c0,0,0.001,0.005,0.003,0.015l0.285-0.024l0.019-0.537l-0.982-0.447l-0.056-0.258l0.815-0.278l0.036-0.78
			l-0.852-0.519l-0.056-1.315l-1.168,0.574h-0.426l0.112-1.001l-1.59-0.375l-0.658,0.497v1.516l-1.183,0.375l-0.474,0.988
			l-0.514,0.083v-1.264l-1.112-0.154l-0.556-0.362l-0.224-0.819l1.989-1.164l0.973-0.296l0.098,0.654l0.542-0.028l0.042-0.329
			l0.567-0.081l0.01-0.115l-0.244-0.101l-0.056-0.348l0.697-0.059l0.421-0.438l0.023-0.032l0.005,0.002l0.128-0.132l1.465-0.185
			l0.648,0.55l-1.699,0.905l2.162,0.51l0.28-0.723h0.945l0.334-0.63l-0.668-0.167V6.212L22.69,5.284l-1.446,0.167l-0.816,0.427
			l0.056,1.038l-0.853-0.13L19.5,6.212l0.817-0.742l-1.483-0.074l-0.426,0.129l-0.185,0.5l0.556,0.094l-0.111,0.556l-0.945,0.056
			l-0.148,0.37l-1.371,0.038c0,0-0.038-0.778-0.093-0.778c-0.055,0,1.075-0.019,1.075-0.019l0.817-0.798l-0.446-0.223l-0.593,0.576
			l-0.984-0.056l-0.593-0.816h-1.261L12.81,6.008h1.206l0.11,0.353l-0.313,0.291l1.335,0.037l0.204,0.482l-1.503-0.056l-0.073-0.371
			L12.831,6.54L12.33,6.262l-1.125,0.009C14.888,3.588,19.417,2,24.312,2c5.642,0,10.797,2.109,14.73,5.574l-0.265,0.474
			l-1.029,0.403l-0.434,0.471l0.1,0.549l0.531,0.074l0.32,0.8l0.916-0.369l0.151,1.07h-0.276l-0.752-0.111l-0.834,0.14l-0.807,1.14
			l-1.154,0.181l-0.167,0.988l0.487,0.115l-0.141,0.635l-1.146-0.23l-1.051,0.23l-0.223,0.585l0.182,1.228l0.617,0.289l1.035-0.006
			l0.699-0.063l0.213-0.556l1.092-1.419l0.719,0.147l0.708-0.64l0.132,0.5l1.742,1.175l-0.213,0.286l-0.785-0.042l0.302,0.428
			l0.483,0.106l0.566-0.236l-0.012-0.682l0.251-0.126l-0.202-0.214l-1.162-0.648l-0.306-0.861h0.966l0.309,0.306l0.832,0.717
			l0.035,0.867l0.862,0.918l0.321-1.258l0.597-0.326l0.112,1.029l0.583,0.64l1.163-0.02c0.225,0.579,0.427,1.168,0.604,1.769
			L45.592,18.139z M13.261,11.046l0.584-0.278l0.528,0.126l-0.182,0.709l-0.57,0.181L13.261,11.046z M16.36,12.715v0.459h-1.334
			l-0.5-0.139l0.125-0.32l0.641-0.265h0.876v0.265H16.36z M16.974,13.355V13.8l-0.334,0.215l-0.416,0.077c0,0,0-0.667,0-0.737
			H16.974z M16.598,13.174v-0.529l0.459,0.418L16.598,13.174z M16.807,14.244v0.433l-0.319,0.32h-0.709l0.111-0.486l0.335-0.029
			l0.069-0.167L16.807,14.244z M15.041,13.355h0.737l-0.945,1.321l-0.39-0.209l0.084-0.556L15.041,13.355z M18.059,14.092v0.432
			H17.35l-0.194-0.28v-0.402h0.056L18.059,14.092z M17.404,13.498l0.202-0.212l0.341,0.212l-0.273,0.225L17.404,13.498z
			 M45.954,19.265l0.07-0.082c0.029,0.126,0.06,0.252,0.088,0.38L45.954,19.265z"}]
    [:path {:d "M3.782,14.884v0.696c0.243-0.568,0.511-1.122,0.798-1.665L3.782,14.884z"}]]])

(def slides
  [:g {:data-title "Stars"}
   thematic
   saturn
   night-sky
   flying-saucer
   satellite
   earth])
