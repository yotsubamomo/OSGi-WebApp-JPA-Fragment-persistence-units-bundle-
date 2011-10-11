package com.gfactor.page.showtable.page;

import java.util.Iterator;

import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.OddEvenItem;
import org.apache.wicket.markup.repeater.RefreshingView;
import org.apache.wicket.markup.repeater.ReuseIfModelsEqualStrategy;
import org.apache.wicket.markup.repeater.util.ModelIteratorAdapter;
import org.apache.wicket.model.IModel;

import com.gfactor.page.showtable.internal.TableInfo;

public class ShowTablePage extends WebPage {
	private TableInfo selected;
	final Form<?> form;
	
	
	public ShowTablePage() {
		form = new Form("form");
		add(form);

		// create a repeater that will display the list of TableInfos.
		RefreshingView<TableInfo> refreshingView = new RefreshingView<TableInfo>("simple") {
			@Override
			protected Iterator<IModel<TableInfo>> getItemModels() {
				// for simplicity we only show the first 10 TableInfos
				SortParam sort = new SortParam("firstName", true);
				// Iterator<TableInfo> TableInfos =
				// DatabaseLocator.getDatabase().find(0, 10, sort).iterator();
				Iterator<TableInfo> TableInfos = null;
				// the iterator returns TableInfo objects, but we need it to
				// return models, we use this handy adapter class to perform
				// on-the-fly conversion.
				return new ModelIteratorAdapter<TableInfo>(TableInfos) {

					@Override
					protected IModel<TableInfo> model(TableInfo object) {
						// return new CompoundPropertyModel<TableInfo>(new
						// DetachableTableInfoModel(object));
						return null;
					}

				};

			}

			@Override
			protected void populateItem(final Item<TableInfo> item) {
				// populate the row of the repeater
				IModel<TableInfo> TableInfo = item.getModel();
				item.add(new ActionPanel("actions", TableInfo));
				item.add(new TextField<Long>("id"));
				item.add(new TextField<String>("firstName"));
				item.add(new TextField<String>("lastName"));
				item.add(new TextField<String>("homePhone"));
				item.add(new TextField<String>("cellPhone"));
			}

			@Override
			protected Item<TableInfo> newItem(String id, int index,IModel<TableInfo> model) {
				// this item sets markup class attribute to either 'odd' or
				// 'even' for decoration
				return new OddEvenItem<TableInfo>(id, index, model);
			}
		};

		// because we are in a form we need to preserve state of the component
		// hierarchy (because it might contain things like form errors that
		// would be lost if the hierarchy for each item was recreated every
		// request by default), so we use an item reuse strategy.
		refreshingView.setItemReuseStrategy(ReuseIfModelsEqualStrategy.getInstance());

		form.add(refreshingView);
	}
	
	
	public TableInfo getSelected() {
		return selected;
	}



	public void setSelected(TableInfo selected) {
		addStateChange();
		this.selected = selected;
	}



	/**
	 * Panel that houses row-actions
	 */
	private class ActionPanel extends Panel
	{
		/**
		 * @param id
		 *            component id
		 * @param model
		 *            model for TableInfo
		 */
		public ActionPanel(String id, IModel<TableInfo> model)
		{
			super(id, model);
			add(new Link("select")
			{
				@Override
				public void onClick()
				{
					setSelected((TableInfo)ActionPanel.this.getDefaultModelObject());
					
				}
			});

			SubmitLink removeLink = new SubmitLink("remove", form)
			{
				@Override
				public void onSubmit()
				{
					TableInfo TableInfo = (TableInfo)ActionPanel.this.getDefaultModelObject();
					info("Removed TableInfo " + TableInfo);
//					DatabaseLocator.getDatabase().delete(TableInfo);
				}
			};
			removeLink.setDefaultFormProcessing(false);
			add(removeLink);
		}
	}
}
