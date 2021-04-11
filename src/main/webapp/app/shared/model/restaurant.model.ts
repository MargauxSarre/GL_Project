import { ITypeCommerce } from 'app/shared/model/type-commerce.model';

export interface IRestaurant {
  id?: number;
  nom?: string;
  adresse?: string;
  compteId?: number;
  typeCommerces?: ITypeCommerce[];
}

export class Restaurant implements IRestaurant {
  constructor(
    public id?: number,
    public nom?: string,
    public adresse?: string,
    public compteId?: number,
    public typeCommerces?: ITypeCommerce[]
  ) {}
}
