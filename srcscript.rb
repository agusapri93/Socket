source ../res/pos-db-env
bin/spring stop
rails c
ServerState.first.name

csv_text = File.read('/opt/pos/stock.csv');
      list_data = CSV.parse(csv_text, headers: false, col_sep: ',');
      ActiveRecord::Base.transaction do
        item_updates = {};
        batch_updates = {};
        batch_no_updates = {};
 
        batch_date_updates = {};
        list_data[1..-1].each do |data|

          csv_item = Item.where(sap_code: data[0]).first;
          next if csv_item.blank? or data[3].blank?
          item_updates[csv_item.id] = {:stocks => data[3].to_i};
          first_batch = csv_item.item_batches.select(:id,:stocks).where(:batch_number => "-").first;
          if not first_batch.nil?
            batch_id = first_batch.id;
            batch_updates[batch_id] = {:stocks => data[3].to_i };
            batch_no_updates[batch_id] = {:batch_number => data[1] } if not data[1].blank?
            batch_date_updates[batch_id] = {:expired_date => data[2].to_s.to_date } if not data[2].blank?
          else
            batch_no = "-" if data[1].blank?
            ItemBatch.create!(stocks: data[3].to_i, batch_number: batch_no, expired_date: data[2].to_s.to_date );
          end
        end;
        Item.update(item_updates.keys,item_updates.values);
        ItemBatch.update(batch_updates.keys,batch_updates.values);
        ItemBatch.update(batch_no_updates.keys,batch_no_updates.values);
        ItemBatch.update(batch_date_updates.keys,batch_date_updates.values);
        Item.update_all(:init => true);

      end;

	  
source ../res/pos-db-env 
bin/spring stop
rails c
Item.where('stocks > 0').count 
ItemBatch.where('stocks > 0').count
