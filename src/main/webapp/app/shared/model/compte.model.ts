export interface ICompte {
  id?: number;
  prenom?: string;
  nom?: string;
  adresse?: string;
  telephone?: string;
  courseId?: number;
}

export class Compte implements ICompte {
  constructor(
    public id?: number,
    public prenom?: string,
    public nom?: string,
    public adresse?: string,
    public telephone?: string,
    public courseId?: number
  ) {}
}
