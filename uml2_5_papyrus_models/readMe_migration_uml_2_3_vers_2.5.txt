L'ancien produit Topcased avait une version de l'éditeur uml papyrus 
en phase avec UML 2.3

Les versions récentes de Papyrus (1.xxx) que l'on trouve maintenant pour 
eclipse "Luna" , "Mars" , ... sont en phase avec UML 2.5 .

=======
Entete d'un fichier ".uml" en ancienne version 2.3:

<?xml version="1.0" encoding="UTF-8"?>
<xmi:XMI xmi:version="2.1" 
xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"
xmlns:uml="http://www.eclipse.org/uml2/3.0.0/UML"
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xmlns:Documentation="http://Papyrus/schemas/Documentation/_vaU6gAEYEeCIz8iAxBJnfA/0" 
  xmlns:ecore="http://www.eclipse.org/emf/2002/Ecore" 
  xmlns:ntiers="http:///schemas/ntiers/_ARg8ICEHEeOT_fjNFFfTPw/20"
   xsi:schemaLocation="http://Papyrus/schemas/Documentation/_vaU6gAEYEeCIz8iAxBJnfA/0 pathmap://Papyrus.profile.uml#_vaU6ggEYEeCIz8iAxBJnfA http:///schemas/ntiers/_ARg8ICEHEeOT_fjNFFfTPw/20 file:/C:/tp/tp-uml/my-topcased-uml-wksp/uml2_papyrus_topcased/Models/profiles/n-tiers.profile.uml#_ARg8ISEHEeOT_fjNFFfTPw">

=======
Entete d'un fichier ".uml" en version 2.5:

<?xml version="1.0" encoding="UTF-8"?>
<xmi:version="20131001"
 xmlns:xmi="http://www.omg.org/spec/XMI/20131001" 
 xmlns:uml="http://www.eclipse.org/uml2/5.0.0/UML" 
 
 ecore (2002) est en même version pour UML 2.3 et pour UML2.5 :
 <?xml version="1.0" encoding="UTF-8"?>
<xmi:version="20131001"
 xmlns:xmi="http://www.omg.org/spec/XMI/20131001" 
 xmlns:ecore="http://www.eclipse.org/emf/2002/Ecore" 
 xmlns:uml="http://www.eclipse.org/uml2/5.0.0/UML" 

======
pour que acceleo_m2t arrive bien à interpréter les fichiers ".uml" en version 2.5
il faut (après avoir changer l'entête 2.3 vers 2.5) supprimer plein de choses inutiles (enlevées dans la Spec UML 2.5):

* supprimer les quelques éléments suivants dans l'entête du fichier ".uml":
xmlns:css="http://www.eclipse.org/papyrus/infra/gmfdiag/css" 
xmlns:Documentation="http://Papyrus/schemas/Documentation/_vaU6gAEYEeCIz8iAxBJnfA/0" 
xsi:schemaLocation="http://Papyrus/schemas/Documentation/... pathmap://Papyrus.profile.uml#_vaU6"

supprimer (en bas de xxx.uml): 
 <css:ModelStyleSheets xmi:id="_iR2JYGNhEeWNAZVYjP2wAQ"/>

* près des diagrammes de séquences (ou d'activités) supprimer toutes les lignes en 
<packagedElement xmi:type="uml:ExecutionEvent" xmi:id="_aaS_URBUEeWIjMMeW0HwNQ" name="ExecutionEvent0"/>
<packagedElement xmi:type="uml:SendOperationEvent" xmi:id="_e4TbsRBUEeWIjMMeW0HwNQ" name="SendOperationEvent"/>
<packagedElement xmi:type="uml:ReceiveOperationEvent" xmi:id="_e4mWoRBUEeWIjMMeW0HwNQ" name="ReceiveOperationEvent"/>

et supprimer l'attribut event="...." dans les 
<fragment xmi:type="uml:......OccurrenceSpecification"  covered="_-dIw4BBTEeWIjMMeW0HwNQ" event="_aaS_UBBUEeWIjMMeW0HwNQ" />
(près des <lifeLine...> des diag de séquence).

* Supprimer dans le bas du fichier ".uml" toutes les lignes en
<Documentation:Documentation xmi:id="_B9rc4Q_7EeWIjMMeW0HwNQ" base_Comment="_B9rc4A_7EeWIjMMeW0HwNQ"/>

=======
Passer de la version 2.3 à 2.5 est (lorsque c'est possible) important pour:
- que la génération de code acceleo soit en phase :
  UML 2.5 est attendu par les versions récentes d'accéléo M2T !!!
- avoir sur le long terme des modèles pas trop dépassés
... 