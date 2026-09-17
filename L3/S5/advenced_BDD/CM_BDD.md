```sql
Select * from Artiste AS A , Films AS
where A.id = F.realisation //jointure
and A.nom = 'Copalla' //filtre
```

**Ex :**

$\sigma_{nom=`Copalla`}(Artiste \bowtie_{id=realisation}Films)$


