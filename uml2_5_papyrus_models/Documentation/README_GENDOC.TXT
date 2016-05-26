Le plugin Gendoc 0.5.x (complémentaire à Papyrus) s'utilise en:
   - se plaçant sur un fichier "xy_template.odt_ou_docx"
   - déclenchant le menu contextuel "Generate documentation using Gendoc"
Pour paramétrer les chemins (fichiers ".uml" et "doc générée") il faut préalablement éditer le début
(xml) du fichier "xy_template.odt_ou_docx" via LibreOffice ou Word (open with / system editor depuis eclipse).

=================================
Quelques astuces "gendoc":
* la variable ${project_loc} est prédéfinie au niveau d'un projet eclipse 
  et est utilisable pour composer des chemins relatifs au projet courant.
* La balise <table> permet d'utérieurement fusionner en un seul tableau
  un sous tableau "odt/docx" d'entête (titre des colonnes)
  un sous tableau "odt/docx" de valeurs (généralement encadré par boucle [for]...[/for])
* <drop/> permet de supprimer des espaces ou saut de lignes inutiles (sorte de trim())
* sort() , liens_hypertextes , .... à étudier dans turoriel officiel "genDoc".
=================================
Le format ".odt" de openOffice/LibreOffice est utilisable sous windows et sous linux.
NB: Les versions ".odt" (libreOffice/ openOffice) fonctionnent.

On peut également utiliser le format ".docx" de word >= 2007.

La conversion directe ".odt" vers ".docx" ne semble pas parfaitement fonctionner
lorsque les fichiers "templates_xy.docx" sont ré-interprétés par Gendoc.

Conversion "odt vers docx" qui fonctionne:
1) générer (en partant de zéro) de nouveaux fichier "templates_xy.docx"
2a) effectuer des "copier/coller" (éventuellement adaptés) progressifs , par parties
2b) tester régulièrement/progressivement.
=================================
L'incorporation d'une sous section liee "generic_sub_template.odt" ne fonctionne
pas avec libreOffice et donc pas de sous fichier "sous template" en mode ".odt" .
et copier/coller + adapation pour chaque modèle (bibliotheque , devise , ....)
=================================
Attention à la version de Gendoc:
pour un eclipse récent (4.3, 4.4 , 4.5 , ...) il faut utiliser
une version 0.5 ou 0.5.1 ou ... du plugin Gendoc (qui il y a longtemps s'appelait "Gendoc2")