import { IProduit } from 'app/shared/model/produit.model';

export interface ICommande {
  id?: number;
  adresse?: string;
  courseId?: number;
  compteId?: number;
  restaurantId?: number;
  produits?: IProduit[];
}

export class Commande implements ICommande {
  constructor(
    public id?: number,
    public adresse?: string,
    public courseId?: number,
    public compteId?: number,
    public restaurantId?: number,
    public produits?: IProduit[]
  ) {}
}
