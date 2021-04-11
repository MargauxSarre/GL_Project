import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'blog',
        loadChildren: () => import('./blog/blog.module').then(m => m.MyblogBlogModule),
      },
      {
        path: 'post',
        loadChildren: () => import('./post/post.module').then(m => m.MyblogPostModule),
      },
      {
        path: 'tag',
        loadChildren: () => import('./tag/tag.module').then(m => m.MyblogTagModule),
      },
      {
        path: 'compte',
        loadChildren: () => import('./compte/compte.module').then(m => m.MyblogCompteModule),
      },
      {
        path: 'restaurant',
        loadChildren: () => import('./restaurant/restaurant.module').then(m => m.MyblogRestaurantModule),
      },
      {
        path: 'type-commerce',
        loadChildren: () => import('./type-commerce/type-commerce.module').then(m => m.MyblogTypeCommerceModule),
      },
      {
        path: 'produit',
        loadChildren: () => import('./produit/produit.module').then(m => m.MyblogProduitModule),
      },
      {
        path: 'commande',
        loadChildren: () => import('./commande/commande.module').then(m => m.MyblogCommandeModule),
      },
      {
        path: 'course',
        loadChildren: () => import('./course/course.module').then(m => m.MyblogCourseModule),
      },
      {
        path: 'avis',
        loadChildren: () => import('./avis/avis.module').then(m => m.MyblogAvisModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class MyblogEntityModule {}
