c-x C-f: Opens a file, ask for the file name. Create the file if not exist.
C-x C-s: Saves the file without a prompt
C-x s: Saves the all files with a prompt
C-s C-w: Saves the file with a different name. Asks for the name.
Everytime a file is saved, Emacs creates a file~, which is the previous version of the file.
Also, Emacs auto-saves everhthing you type to a file named "#filename#".
C-x C-c: to Quits
C-g Always quits the command.

;;;;;;;;;Majorly Overrided;;;;;;;;;;;
;"#Copy&Paste" Overrided by evil-mode.
----------
C-x h: Select the whole buffer
C-k : Vim dd
C-y : Vim p
C-Space: Vim Visual mode?
M-w : Copies the selection into the clipboard
C-w : Cut the selection into the clipboard
In evil-mode the first buffer always goes to the clipboard now. Nice.
----------
;"#Cursor Commands", Partially overrided by evil-mode
----------
C-a / C-e : Beginning/End of a line.
M-> : End of buffer
M-< : Beginning of buffer

;Undo/Redo, Overrided by evil-mode
----------
C-/ : Undo
C-g C-/ : Redo
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;Vim Commands
ma/mA(remove previous a mark) set mark a
'a/`a               back to first of line / exactly mark a
]`/[`               jump list navigation

;Window Commands
----------
C-x 0 : Single Window view.

;Buffer Commands
----------
C-x b : Switches buffers (same as bxut in case evil-mode :b or ls does not work, e.g. in help document)
C-w s : Split the current window vertically. (Vim command)
C-w v : Split the current window horizontally. (Vim command)

C-x o : Switch between windows
C-w h/j/k/l : Switch between windows in a direction. (Vim command)
C-w >/</+/-: Adjust windows width/height
C-w _/=: Adjust windows height

;Help Commands
-------------
C-h 
C-h c : <describe key-combination briefly>
C-h k : <describe key> same as F1-k
C-h m : <describe mode>
C-h f : <describe funtion>
C-h a : apropos-command, fuzzy search for the command
info
C-h v : <describe-variable>
M-x customize-group

;Run Emacs Daemon
-------------
emacs --daemon
emacs --fg-daemon : run in foreground
emacsclient --eval "(kill-emacs)" : in bash to kill the daemon or eval(a-x)  kill-emacs
emacsclient <file> : to access

;Tabs
------------
C-x h then M-x untabify/tabify
https://www.emacswiki.org/emacs/IndentationBasics

;Elisp / REPO(Re-Eval-Print-Loop) 
-----------
C-x C-e : eval-last sexp
M-x byte-compile-file
C-M-i auto-completion
(- 2 5)
'foo!'
(message "abc") : send the message to the mini-buffer
(insert " ;inserted text") : insert text at the cursor location
(quote(1 2 3)) : the list (1,2,3)
'(1 2 3)
(car '(1 2 3)) : the content of the address register
(cdr '(1 2 3)) : the content of the decrement register
'() : () : nil : all the same and falsy 
(null '()) : check if null
(cons '(1 2) (cons '(3 4) '()))
(cons '(1 2) (cons '(3 4) nil))
(set 'some-list '(1 2 3)) : set and setq(set quote) and global
some-list 
(let ((a 1)
      (b 5))
  (format "a is %d and b is %d" a b))
(let* ((a 1)
      (b (+ a 5)))
  (format "a is %d and b is %d" a b)) ;: let* is sequential
(defun square (x)
  (* x x))
(square 2)
(defun distance (x1 y1 x2 y2)
  (sqrt (+ (square (- x1 x2)) (square (- y1 y2))))
  )
(distance 1 2 3 4)

;;Conditions
(when (= 1))
(defun evens-or-odds (n)
  (if (= 0 (% n 2))
      "even"
    "odd"))
(evens-or-odds 4)
(defun conditions (n)
  (cond
   ((= n 1) "bulbous")
   ((= n 2) "bouffant")
   (t "gazebo")
   )
  )
(conditions '(33)) : fail because the function '= need a number as input
(conditions 4)

;;Anoymous functions. lambda is executable. note the parentheses
(lambda (x) (* x x x))
( (lambda (x) (* x x x)) 5)
( (lambda () (setq a 2)) )
(setq a 1)
a
(fset 'cubic (lambda(x) (* x x x))) : fset set 'cubic to the function space
(set 'cubic 1)
cubic : eval to 1
(cubic 4) : eval to 64

(global-set-key (kbd "M-#") 'sort-lines) ;; global applies to major-mode
(add-hook 'c-mode-common-hook
	  (lambda()
	    (local-set-key (kud "<f5>") 'recompile)))
;;Java settings
(add-hook 'java-mode-hook
    (lambda ()
	(set (make-local-variable 'compile-command)
	    (concat "javac "
		    (if buffer-file-name
			buffer-file-name)))))
;(file-name-sans-extension (buffer-file-name))
(add-hook 'java-mode-hook
      (lambda()
        (local-set-key (kbd "<f5>") (lambda()
                                      (interactive)
                                      (if (get-buffer '"*compilation*")
                                        (progn
                                          (kill-buffer '"*compilation*")
                                            (compile compile-command))
                                        (compile compile-command))))))
;;f6 run(or test later?)    
(add-hook 'java-mode-hook
	  (lambda()
	    (local-set-key (kbd "<f6>") (lambda() (interactive) (shell-command (concat "java "
										       (if buffer-file-name
											   (shell-quote-argument
											    (file-name-nondirectory (file-name-sans-extension buffer-file-name))))"&")
									       (get-buffer-create '"*compilation*"))))))
(load-file user-init-file) ;;reload init file
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
Block execution -> org mode 


;;lsp-mode
;;c/cpp company auto-complete
(use-package company
	     :ensure t
	     :config
	     (setq company-idle-delay 0)
	     (setq company-minimum-prefix-length 3))
(with-eval-after-load 'company
  (define-key company-active-map (kbd "M-n") nil)
  (define-key company-active-map (kbd "M-p") nil)
  (define-key company-active-map (kbd "C-n") #'company-select-next)
  (define-key company-active-map (kbd "C-p") #'company-select-previous))
(use-package company-irony
	     :ensure t
	     :config
	     (require`company)
	     (add-to-list `company-backends `company-irony))
(use-package irony
	     :ensure t
	     :config
	     (add-hook 'c++-mode-hook 'irony-mode)
	     (add-hook 'c-mode-hook 'irony-mode)
	     (add-hook 'irony-mode-hook 'irony-cdb-autosetup-compile-options))
(with-eval-after-load 'company
	     (add-hook 'c++-mode-hook 'company-mode)
	     (add-hook 'c-mode-hook 'company-mode))

;;lsp-java




