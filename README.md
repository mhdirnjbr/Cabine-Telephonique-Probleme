
# Probleme de Cabine Téléphonique
### Description
<p>On formalise ce problème en utilisant un graphe de 7 sommet et et avec une matrice d'adjacence (des poids). 
Le sommet 0 c’est un sommet fictif puis les sommets de
1 à 6, désignent progressivement le numéro de mois associé.</p>
En utilisant l’algorithme de recherche de coût uniforme (Uniform cost search), on réussit à trouver le chemin optimal
qui minimise le plus le coût. Dans ce contexte, la politique d’approvisionnement qui minimise la somme des deux coût,
apprivoisement et stockage. <p>Selon le résultat d’algorithme, la politique optimale consiste à approvisionner une fois
au départ pour les trois premiers mois, ensuite approvisionner une autre fois pour le mois de 4 et finalement 
approvisionner pour le mois de 5 et 6. Autrement dit, le chemin optimal est :<br><br> 0 → 3 → 4 → 6 qui a pour le coût minimum
de 8000 euros.</p>