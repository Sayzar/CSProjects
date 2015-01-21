;;Cesar Ramirez
;;45406343
;;cesargr@uci.edu

;;EXERCISE 1
;;Recursively search list, determines if the car of the list is a list
;;searches through the nested list
;;if returns nil, searches the rest of the main list
(defun contains (a lst)
	(cond 
		((null lst) nil)
		((listp (car lst)) (or (contains a (car lst)) (contains a (cdr lst))))
		((eq a (car lst)) t)
		(t (contains a (cdr lst)))))

;;EXERCISE 2
;;if just an atom, make the list
;;if a list, add to the end
;;iterate through until the end
(defun insert-q (obj lst)
	(cond
		((atom lst) (cons obj nil))
		((listp lst) (cons (car lst) (insert-q obj (cdr lst))))))

;;EXERCISE 3
;;helper method to append two lists togther
;;helper method to find the series and return the cdr of the main str
;;final method that returns the new list
(defun sub-pattern-app (pat lst)
	(cond
		((null lst) pat)
		((null pat) lst)
		(t (sub-pattern-app (insert-q (car lst) pat) (cdr lst)))  
		))

(defun sub-pattern-find (pat lst)
	(cond
		((null lst) nil)
		((null pat) nil)
		((null (cdr pat)) (eq (car pat) (car lst))  (cdr lst))
		((eq (car pat) (car lst)) (sub-pattern-find (cdr pat) (cdr lst))  )
		(t(sub-pattern-find pat (cdr lst)))
		))

(defun sub-pattern (pat lst)
	(cond
		((null lst) nil)
		((null pat) nil)
		((null (sub-pattern-find pat lst)) nil)
		((sub-pattern-app pat (sub-pattern-find pat lst)))
		))

;;EXERCISE 4
;; seperate helper method to do less operation and return the value
;;		-for (car(car lst)) 
;; cons the values into one list
(defun mapping-less(a lst)
	(cond
		((> a (car lst)) (car(cdr lst)))
		))
(defun mapping(lst a)
	(cond
		((null lst) nil)
		((not (mapping-less a (car lst))) (mapping (cdr lst) a))
		(t(cons (mapping-less a (car lst)) (mapping (cdr lst) a)))
		))

;;EXERCISE 5
;;recursive search
(defun first-atom(lst)
	(cond
		((null lst) nil)
		((listp (car lst)) (first-atom (car lst)))
		((atom (car lst)) (car lst))
		(t(first-atom (cdr lst))) 
		))

;;EXERCISE 6
;;hahve an extra conditional based on if there is a sublist
;;if sublist becomes null, return the cdr
;;cons the remaining elemetns
(defun rest-list(lst)
	(cond
		((null lst) nil)
		((listp (car lst))
			(cond
				((null (rest-list(car lst))) (cdr lst))
				(t(cons (rest-list(car lst)) (cdr lst))))) 
		((atom (car lst)) (cdr lst))
		))

;;EXERCISE 7
;;verify we have a symbol
;;use first-atom to locate the symb we want
;;		-then get the consecutive value and return
;;iterate through remainder of list
(defun find-all(symb lst)
	(cond
		((null lst) nil)
		((not(symbolp symb)) nil)
		((eq (first-atom lst) symb) (cons (first-atom (rest-list lst)) (find-all symb (rest-list lst))))
		(t( find-all symb (rest-list lst)))))

;;EXERCISE 8
;;helper method that holds the count
;;increments when a match is found
;;recursive call and use of rest-list
(defun occ-helper(lst a n)
	(cond 
		((null lst) n)
		((eq (first-atom lst) a) (occ-helper (rest-list lst) a (+ 1 n)))
		(t(occ-helper (rest-list lst) a n))
		))
(defun occ(lst a)
	(occ-helper lst a 0))

;;EXERCISE 9
;;Use insert q to make a new list
;;checks for sublist
;;iterate and "push"
(defun total-reverse(lst)
	(cond 
		((null lst) nil)
		((listp (car lst)) (insert-q (total-reverse (car lst)) (total-reverse (cdr lst ))))
		(t(insert-q (car lst) (total-reverse(cdr lst))))
		))