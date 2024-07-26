; Mapas

(def estoque {"Mochila" 10, "Camiseta" 5})
(println "Temos" (count estoque) "elementos")

; Não necessariamente segue a ordem
(println "Chaves são:" (keys estoque))
(println "Valores são:" (vals estoque))

; keyword
; :mochila
(def estoque {:mochila 10 :camiseta 5})

; Associar elemento, lembrando que ele cria um novo mapa e não altera o estoque criado
(println (assoc estoque :cadeira 3))

(println (assoc estoque :mochila 2))

; Update mapa
(println (update estoque :mochila inc))

(defn tira-um
  [valor]
  (- valor 1))

(println (update estoque :mochila tira-um))
(println (update estoque :mochila #(- % 3)))

; "Remover"
(println (dissoc estoque :mochila))

(println "\n\n")

(def pedido {:mochila {:quantidade 2, :preco 80},
             :camiseta {:quantidade 3, :preco 40}})

(def pedido (assoc pedido :chaveiro {:quantidade 1, :preco 10}))

(println pedido)
(println "\n")
; Acessar valores especificos
(println (pedido :mochila))
(println (get pedido :mochila))
(println (get pedido :cadeira 0)) ; Valores padrão 0
(println (get pedido :cadeira {})) ; Valores padrão {}
(println (:mochila pedido)) ; Pode ser invocada como função, ela implementa uma interface
(println (:cadeira pedido))
(println (:cadeira pedido {})) ; Com valor padrão

; Acessar atributos especificos da mochila
(println (:quantidade (:mochila pedido)))

; Atualizar elementos dentro do mapa de mapas
(println (update-in pedido [:mochila :quantidade] inc))

; Threading (encadeando) como um fio numa agulha
(println (-> pedido
             :mochila
             :quantidade))

(def
  clientes {
            :15 {
                 :nome "Guilherme"
                 :certificados ["Clojure" "Java" "Machine Learning"]}})

(println clientes)
(println (-> clientes :15 :certificados count))



