package fr.rexel.api.controller.dto;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

public class OrderRequestDto {

    public Data data;

    public static class Data {
        public String type;  // = "orders"
        public Attributes attributes;
        public Relationships relationships;
        public Meta meta;
    }

    public static class Attributes {
        public String number;
        public Boolean autorefresh;
        public Boolean place_async;
        public Boolean guest;
        public String customer_email;
        public String language_code;
        public String currency_code;
        public String shipping_country_code_lock;
        // Montants en centimes
        public Long subtotal_amount_cents;
        public Long shipping_amount_cents;
        public Long discount_amount_cents;
        public Long total_tax_amount_cents;
        public Long total_amount_cents;
        // Dates
        public OffsetDateTime placed_at;
        // Références externes, metadata
        public String reference;
        public String reference_origin;
        public Map<String, String> metadata;
        // timestamps de création / mise à jour
        public OffsetDateTime created_at;
        public OffsetDateTime updated_at;
    }

    public static class Relationships {
        public RelationshipObject market;
        public RelationshipObject customer;
        public RelationshipObject shipping_address;
        public RelationshipObject billing_address;
        public RelationshipObject store;
        public RelationshipObject default_shipping_method;
        public RelationshipObject default_payment_method;
        public LineItemsRelation line_items;
        public ShipmentsRelation shipments;
        public TransactionsRelation transactions;
        public AttachmentsRelation attachments;
    }

    public static class RelationshipObject {
        public RelationData data;
    }

    public static class RelationData {
        public String type;
        public String id;
    }

    public static class LineItemsRelation {
        public List<LineItem> data;
    }

    public static class LineItem {
        public String type;  // "line_items"
        public String id;
        public LineItemAttributes attributes;
    }

    public static class LineItemAttributes {
        public String sku_code;
        public String name;
        public Integer quantity;
        public Long unit_price_cents;
        public Long total_amount_cents;
    }

    public static class ShipmentsRelation {
        public List<RelationData> data;
    }

    public static class TransactionsRelation {
        public List<RelationData> data;
    }

    public static class AttachmentsRelation {
        public List<RelationData> data;
    }

    public static class Meta {
        public String mode;  // e.g. "live" ou "test"
    }
}
