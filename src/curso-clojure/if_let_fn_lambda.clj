(ns curso.if-let-fn-lambda)

(defn aplica-desconto?
  [valor-bruto]
  (if (> valor-bruto 100)
    true))

(defn aplica-desconto-when?
  [valor-bruto]
  (println "Chamando com when, só aceita primeiro")
  (when (> valor-bruto 100) true))

(println (aplica-desconto-when? 1000))

(defn aplica-desconto?
  [valor-bruto]
  (> valor-bruto 100))

(println (aplica-desconto? 1000))

(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto         (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

;; (println (valor-descontado 1000))
;; (println  (valor-descontado 100))

;; Passa função por parâmetro e executa de acordo com a função passada

(defn mais-caro-que-100?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  "Retorna o valor com desconto de 10% se deve aplicar desconto"
  [aplica? valor-bruto]
  (if (aplica? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto         (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println (valor-descontado mais-caro-que-100? 1000))
(println  (valor-descontado mais-caro-que-100? 100))

(println "Função sem nome ou anônima")
(println (valor-descontado (fn [valor-bruto] (> valor-bruto 100)) 1000))
(println  (valor-descontado (fn [valor-bruto] (> valor-bruto 100)) 100))


(println "lambda ou função anônima")
(println (valor-descontado #(> %1 100) 1000))
(println  (valor-descontado #(> %1 100) 100))

(println "lambda quando só tem 1 argumento")
(println (valor-descontado #(> % 100) 1000))
(println  (valor-descontado #(> % 100) 100))

; Funções são coisas
(def mais-caro-que-100? (fn [valor-bruto] (> valor-bruto 100)))
(def mais-caro-que-100? #(> % 100))

(println (valor-descontado mais-caro-que-100? 1000))
(println (valor-descontado mais-caro-que-100? 100))








