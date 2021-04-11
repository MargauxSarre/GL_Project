import { ICommande } from 'app/shared/model/commande.model';

export interface IProduit {
  id?: number;
  nom?: string;
  prix?: number;
  description?: string;
  restaurantId?: number;
  commandes?: ICommande[];
}

export class Produit implements IProduit {
  constructor(
    public id?: number,
    public nom?: string,
    public prix?: number,
    public description?: string,
    public restaurantId?: number,
    public commandes?: ICommande[]
  ) {}
}
