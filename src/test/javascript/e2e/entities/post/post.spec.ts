import { browser, ExpectedConditions as ec, protractor, promise } from 'protractor';
import { NavBarPage, SignInPage } from '../../page-objects/jhi-page-objects';

import { PostComponentsPage, PostDeleteDialog, PostUpdatePage } from './post.page-object';

const expect = chai.expect;

describe('Post e2e test', () => {
  let navBarPage: NavBarPage;
  let signInPage: SignInPage;
  let postComponentsPage: PostComponentsPage;
  let postUpdatePage: PostUpdatePage;
  let postDeleteDialog: PostDeleteDialog;

  before(async () => {
    await browser.get('/');
    navBarPage = new NavBarPage();
    signInPage = await navBarPage.getSignInPage();
    await signInPage.autoSignInUsing('admin', 'admin');
    await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
  });

  it('should load Posts', async () => {
    await navBarPage.goToEntity('post');
    postComponentsPage = new PostComponentsPage();
    await browser.wait(ec.visibilityOf(postComponentsPage.title), 5000);
    expect(await postComponentsPage.getTitle()).to.eq('myblogApp.post.home.title');
    await browser.wait(ec.or(ec.visibilityOf(postComponentsPage.entities), ec.visibilityOf(postComponentsPage.noResult)), 1000);
  });

  it('should load create Post page', async () => {
    await postComponentsPage.clickOnCreateButton();
    postUpdatePage = new PostUpdatePage();
    expect(await postUpdatePage.getPageTitle()).to.eq('myblogApp.post.home.createOrEditLabel');
    await postUpdatePage.cancel();
  });

  it('should create and save Posts', async () => {
    const nbButtonsBeforeCreate = await postComponentsPage.countDeleteButtons();

    await postComponentsPage.clickOnCreateButton();

    await promise.all([
      postUpdatePage.setTitleInput('title'),
      postUpdatePage.setContentInput('content'),
      postUpdatePage.setDateInput('01/01/2001' + protractor.Key.TAB + '02:30AM'),
      postUpdatePage.blogSelectLastOption(),
      // postUpdatePage.tagSelectLastOption(),
    ]);

    expect(await postUpdatePage.getTitleInput()).to.eq('title', 'Expected Title value to be equals to title');
    expect(await postUpdatePage.getContentInput()).to.eq('content', 'Expected Content value to be equals to content');
    expect(await postUpdatePage.getDateInput()).to.contain('2001-01-01T02:30', 'Expected date value to be equals to 2000-12-31');

    await postUpdatePage.save();
    expect(await postUpdatePage.getSaveButton().isPresent(), 'Expected save button disappear').to.be.false;

    expect(await postComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeCreate + 1, 'Expected one more entry in the table');
  });

  it('should delete last Post', async () => {
    const nbButtonsBeforeDelete = await postComponentsPage.countDeleteButtons();
    await postComponentsPage.clickOnLastDeleteButton();

    postDeleteDialog = new PostDeleteDialog();
    expect(await postDeleteDialog.getDialogTitle()).to.eq('myblogApp.post.delete.question');
    await postDeleteDialog.clickOnConfirmButton();

    expect(await postComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeDelete - 1);
  });

  after(async () => {
    await navBarPage.autoSignOut();
  });
});
