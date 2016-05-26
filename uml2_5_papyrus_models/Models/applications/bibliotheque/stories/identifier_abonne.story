scenario non abonne
given "abonné pas encore enregistré"
when "identifiant abonné invalide"
then "statut et/ou message non identifié"


scenario abonnement expiré
given "abonné déjà enregistré mais depuis plus d'un an"
when "identifiant invalide"
then "statut non identifié"
  and "message abonnement expiré (à renouveller)"