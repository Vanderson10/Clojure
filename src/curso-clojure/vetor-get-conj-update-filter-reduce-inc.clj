; Vetores imutáveis
(def precos [30 700 1000])

; Acessar diretamente, caso não exista o indice ele retorna erro
(println (precos 0))
;(println (precos 17))
; Acessar com o get, não dá erro caso a posição não exista
(println (get precos 0))
(println (get precos 2))
;(println (get precos 17))

; Colocar valor padrão em caso de inexistencia de indice
(println "retorna null" (get precos 17))
(println "Valor padrão 0, mas existe" (get precos 2 0))
(println "Valor padrão 0, Não existe" (get precos 17 0))

; Adicionar valores em vetor
(println (conj precos 5))
(println precos)

; Incrementar
(println (+ 5 1))
(println (inc 5))

; Update valor de um vetor, lembrando que ele de fato não muda pois é imutável
(println (update precos 0 inc))
(println precos)

(defn soma-3
  [valor]
  (println "estou somando 3 em " valor)
  (+ valor 3))

(println (update precos 0 soma-3))

; Código aula 4

(defn aplica-desconto?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto         (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

; Aplica função para todos
(println (map valor-descontado precos))

; Filtra elementos pares, even função interna valida se é par
(println (filter even? (range 10)))

(println "vetor" precos)
(println "filter" (filter aplica-desconto? precos))

(println "map apos o filter" (map valor-descontado (filter aplica-desconto? precos)))

; Somar todos os preços
(println (reduce + precos))

(defn minha-soma
  [valor-1 valor-2]
  (println "somando" valor-1 valor-2)
  (+ valor-1 valor-2))

(println (reduce minha-soma precos))
(println (reduce minha-soma (range 10)))

; Começa somando com o 0 que passei
(println (reduce minha-soma 0 precos))



