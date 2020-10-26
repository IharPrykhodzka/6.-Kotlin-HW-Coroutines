package com.example.hw6coroutines

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hw6coroutines.model.*
import java.lang.IllegalArgumentException

class AdapterPosts(private val items: List<StandardPost>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class StandardPostUI(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val icon: ImageView = itemView.findViewById(R.id.icon)
        val date: TextView = itemView.findViewById(R.id.date)
        val author: TextView = itemView.findViewById(R.id.author)
        val text: TextView = itemView.findViewById(R.id.text)
        val textForLikes: TextView = itemView.findViewById(R.id.forBtnLike)
        val textForComments: TextView = itemView.findViewById(R.id.forBtnComment)
        val textForShares: TextView = itemView.findViewById(R.id.forBtnShare)
        val btnLikes: Button = itemView.findViewById(R.id.btnLike)
        val btnComments: Button = itemView.findViewById(R.id.btnComment)
        val btnShares: Button = itemView.findViewById(R.id.btnShare)

    }

    class EventPostUI(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val icon: ImageView = itemView.findViewById(R.id.iconEventPost)
        val date: TextView = itemView.findViewById(R.id.dateEventPost)
        val author: TextView = itemView.findViewById(R.id.authorEventPost)
        val text: TextView = itemView.findViewById(R.id.textEventPost)
        val textForLikes: TextView = itemView.findViewById(R.id.forBtnLikeEventPost)
        val textForComments: TextView = itemView.findViewById(R.id.forBtnCommentEventPost)
        val textForShares: TextView = itemView.findViewById(R.id.forBtnShareEventPost)
        val btnLikes: Button = itemView.findViewById(R.id.btnLikeEventPost)
        val btnComments: Button = itemView.findViewById(R.id.btnCommentEventPost)
        val btnShares: Button = itemView.findViewById(R.id.btnShareEventPost)
        val btnLocation: Button = itemView.findViewById(R.id.btnMapEventPost)
    }

    class PromotionPostUI(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.findViewById(R.id.iconPromoPost)
        val date: TextView = itemView.findViewById(R.id.datePromoPost)
        val author: TextView = itemView.findViewById(R.id.authorPromoPost)
        val text: TextView = itemView.findViewById(R.id.textPromoPost)
        val textForLikes: TextView = itemView.findViewById(R.id.forBtnLikePromoPost)
        val textForComments: TextView = itemView.findViewById(R.id.forBtnCommentPromoPost)
        val textForShares: TextView = itemView.findViewById(R.id.forBtnSharePromoPost)
        val btnLikes: Button = itemView.findViewById(R.id.btnLikePromoPost)
        val btnComments: Button = itemView.findViewById(R.id.btnCommentPromoPost)
        val btnShares: Button = itemView.findViewById(R.id.btnSharePromoPost)
        val imageBtnLinks: ImageButton = itemView.findViewById(R.id.linkPromoPost)

    }

    class RePostUI(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.findViewById(R.id.iconRePostUser)
        val date: TextView = itemView.findViewById(R.id.dateRePostUser)
        val author: TextView = itemView.findViewById(R.id.authorRePostUser)
        val textForLikes: TextView = itemView.findViewById(R.id.forBtnLikeRePostUser)
        val textForComments: TextView = itemView.findViewById(R.id.forBtnCommentRePostUser)
        val textForShares: TextView = itemView.findViewById(R.id.forBtnShareRePostUser)
        val btnLikes: Button = itemView.findViewById(R.id.btnLikeRePostUser)
        val btnComments: Button = itemView.findViewById(R.id.btnCommentRePostUser)
        val btnShares: Button = itemView.findViewById(R.id.btnShareRePostUser)

        val iconRePost: ImageView = itemView.findViewById(R.id.iconRePost)
        val dateRePost: TextView = itemView.findViewById(R.id.dateRePost)
        val authorRePost: TextView = itemView.findViewById(R.id.authorRePost)
        val textRePost: TextView = itemView.findViewById(R.id.textRePost)
        val imageBtnLinksRePost: ImageButton = itemView.findViewById(R.id.linkRePost)
    }

    class VideoPostUI(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.findViewById(R.id.iconPostWithVideo)
        val date: TextView = itemView.findViewById(R.id.datePostWithVideo)
        val author: TextView = itemView.findViewById(R.id.authorPostWithVideo)
        val text: TextView = itemView.findViewById(R.id.textPostWithVideo)
        val textForLikes: TextView = itemView.findViewById(R.id.forBtnLikePostWithVideo)
        val textForComments: TextView = itemView.findViewById(R.id.forBtnCommentPostWithVideo)
        val textForShares: TextView = itemView.findViewById(R.id.forBtnSharePostWithVideo)
        val btnLikes: Button = itemView.findViewById(R.id.btnLikePostWithVideo)
        val btnComments: Button = itemView.findViewById(R.id.btnCommentPostWithVideo)
        val btnShares: Button = itemView.findViewById(R.id.btnSharePostWithVideo)
        val imageBtnLinks: ImageButton = itemView.findViewById(R.id.videoLinkPostWithVideo)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            STANDARD_POST -> StandardPostUI(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_standard_post, parent, false)
            )
            EVENT_POST -> EventPostUI(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_event_post, parent, false)
            )
            PROMO_POST -> PromotionPostUI(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_promotion_post, parent, false)
            )
            RE_POST -> RePostUI(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_repost, parent, false)
            )
            VIDEO_POST -> VideoPostUI(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_post_with_video, parent, false)
            )
            else -> throw IllegalArgumentException()
        }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        when (holder.itemViewType) {
            STANDARD_POST -> onBindStandard(holder, position)
            PROMO_POST -> onBindPromo(holder, position)
            EVENT_POST -> onBindEvent(holder, position)
            VIDEO_POST -> onBindVideo(holder, position)
            RE_POST -> onBindRePost(holder, position)
            else -> throw IllegalArgumentException()
        }


    private fun onBindStandard(holder: RecyclerView.ViewHolder, position: Int) {
        val standPost = holder as StandardPostUI

        val post = items[position]

        standPost.icon.setBackgroundResource(post.icon)
        standPost.date.text = post.dateForPost
        standPost.author.text = post.author
        standPost.text.text = post.content

        when (post.likedByMe) {
            true -> standPost.btnLikes.setBackgroundResource(R.drawable.ic_baseline_favorite_red_24)
            false -> standPost.btnLikes.setBackgroundResource(R.drawable.ic_baseline_favorite_24)
        }

        if (post.registeredLikes == 0) {
            standPost.textForLikes.visibility = View.GONE
        } else {
            standPost.textForLikes.visibility = View.VISIBLE
            standPost.textForLikes.text = post.registeredLikes.toString()
        }

        standPost.btnLikes.setOnClickListener {
            if (holder.adapterPosition != RecyclerView.NO_POSITION) {
                val stPost = items[holder.adapterPosition]

                stPost.likedByMe = !stPost.likedByMe

                if (post.likedByMe) {
                    post.registeredLikes = post.registeredLikes + 1
                } else {
                    post.registeredLikes = post.registeredLikes - 1
                }

                notifyItemChanged(holder.adapterPosition)
            }
        }

        when (post.commentedByMe) {
            true -> standPost.btnComments.setBackgroundResource(R.drawable.ic_baseline_mode_comment_red_24)
            false -> standPost.btnComments.setBackgroundResource(R.drawable.ic_baseline_mode_comment_24)
        }

        if (post.registeredComments == 0) {
            standPost.textForComments.visibility = View.GONE
        } else {
            standPost.textForComments.visibility = View.VISIBLE
            standPost.textForComments.text = post.registeredComments.toString()
        }

        standPost.btnComments.setOnClickListener {
            if (holder.adapterPosition != RecyclerView.NO_POSITION) {
                val stPost = items[holder.adapterPosition]

                stPost.commentedByMe = !stPost.commentedByMe

                if (post.commentedByMe) {
                    post.registeredComments = post.registeredComments + 1
                } else {
                    post.registeredComments = post.registeredComments - 1
                }

                notifyItemChanged(holder.adapterPosition)
            }
        }



        when (post.sharedByMe) {
            true -> standPost.btnShares.setBackgroundResource(R.drawable.ic_baseline_share_red_24)
            false -> standPost.btnShares.setBackgroundResource(R.drawable.ic_baseline_share_24)
        }

        if (post.registeredShares == 0) {
            standPost.textForShares.visibility = View.GONE
        } else {
            standPost.textForShares.visibility = View.VISIBLE
            standPost.textForShares.text = post.registeredShares.toString()
        }

        standPost.btnShares.setOnClickListener {

            if (holder.adapterPosition != RecyclerView.NO_POSITION) {
                val stPost = items[holder.adapterPosition]
                stPost.sharedByMe = !stPost.sharedByMe
                if (post.sharedByMe) {
                    post.registeredShares = post.registeredShares + 1

                    val intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(
                            Intent.EXTRA_TEXT,
                            """${stPost.id}
${stPost.icon}
${stPost.author}
${stPost.dateForPost}
${stPost.content}""".trimIndent()
                        )
                        type = "text/plain"
                    }
                    val context = holder.author.context
                    context.startActivity(intent)

                } else {
                    post.registeredShares = post.registeredShares - 1
                }
                notifyItemChanged(holder.adapterPosition)
            }
        }


    }


    private fun onBindEvent(holder: RecyclerView.ViewHolder, position: Int) {
        val eventPost = holder as EventPostUI

        val post = items[position]

        eventPost.icon.setBackgroundResource(post.icon)
        eventPost.date.text = post.dateForPost
        eventPost.author.text = post.author
        eventPost.text.text = post.content

        when (post.likedByMe) {
            true -> eventPost.btnLikes.setBackgroundResource(R.drawable.ic_baseline_favorite_red_24)
            false -> eventPost.btnLikes.setBackgroundResource(R.drawable.ic_baseline_favorite_24)
        }

        if (post.registeredLikes == 0) {
            eventPost.textForLikes.visibility = View.GONE
        } else {
            eventPost.textForLikes.visibility = View.VISIBLE
            eventPost.textForLikes.text = post.registeredLikes.toString()
        }

        eventPost.btnLikes.setOnClickListener {
            if (holder.adapterPosition != RecyclerView.NO_POSITION) {
                val stPost = items[holder.adapterPosition]

                stPost.likedByMe = !stPost.likedByMe

                if (post.likedByMe) {
                    post.registeredLikes = post.registeredLikes + 1
                } else {
                    post.registeredLikes = post.registeredLikes - 1
                }

                notifyItemChanged(holder.adapterPosition)
            }
        }

        when (post.commentedByMe) {
            true -> eventPost.btnComments.setBackgroundResource(R.drawable.ic_baseline_mode_comment_red_24)
            false -> eventPost.btnComments.setBackgroundResource(R.drawable.ic_baseline_mode_comment_24)
        }

        if (post.registeredComments == 0) {
            eventPost.textForComments.visibility = View.GONE
        } else {
            eventPost.textForComments.visibility = View.VISIBLE
            eventPost.textForComments.text = post.registeredComments.toString()
        }

        eventPost.btnComments.setOnClickListener {
            if (holder.adapterPosition != RecyclerView.NO_POSITION) {
                val stPost = items[holder.adapterPosition]

                stPost.commentedByMe = !stPost.commentedByMe

                if (post.commentedByMe) {
                    post.registeredComments = post.registeredComments + 1
                } else {
                    post.registeredComments = post.registeredComments - 1
                }

                notifyItemChanged(holder.adapterPosition)
            }
        }



        when (post.sharedByMe) {
            true -> eventPost.btnShares.setBackgroundResource(R.drawable.ic_baseline_share_red_24)
            false -> eventPost.btnShares.setBackgroundResource(R.drawable.ic_baseline_share_24)
        }

        if (post.registeredShares == 0) {
            eventPost.textForShares.visibility = View.GONE
        } else {
            eventPost.textForShares.visibility = View.VISIBLE
            eventPost.textForShares.text = post.registeredShares.toString()
        }

        eventPost.btnShares.setOnClickListener {

            if (holder.adapterPosition != RecyclerView.NO_POSITION) {
                val stPost = items[holder.adapterPosition]
                stPost.sharedByMe = !stPost.sharedByMe
                if (post.sharedByMe) {
                    post.registeredShares = post.registeredShares + 1

                    val intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(
                            Intent.EXTRA_TEXT,
                            """${stPost.id}
${stPost.icon}
${stPost.author}
${stPost.dateForPost}
${stPost.content}
${stPost.linkLocation}""".trimIndent()
                        )
                        type = "text/plain"
                    }
                    val context = holder.author.context
                    context.startActivity(intent)

                } else {
                    post.registeredShares = post.registeredShares - 1
                }
                notifyItemChanged(holder.adapterPosition)
            }
        }

        eventPost.btnLocation.setOnClickListener {
            if (holder.adapterPosition != RecyclerView.NO_POSITION) {
                val stPost = items[holder.adapterPosition]
                val geo = Uri.parse(stPost.linkLocation)
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = geo
                }
                val context = holder.author.context
                context.startActivity(intent)
            }
        }
    }


    private fun onBindPromo(holder: RecyclerView.ViewHolder, position: Int) {
        val promoPost = holder as PromotionPostUI

        val post = items[position]

        promoPost.icon.setBackgroundResource(post.icon)
        promoPost.date.text = post.dateForPost
        promoPost.author.text = post.author
        promoPost.text.text = post.content

        when (post.likedByMe) {
            true -> promoPost.btnLikes.setBackgroundResource(R.drawable.ic_baseline_favorite_red_24)
            false -> promoPost.btnLikes.setBackgroundResource(R.drawable.ic_baseline_favorite_24)
        }

        if (post.registeredLikes == 0) {
            promoPost.textForLikes.visibility = View.GONE
        } else {
            promoPost.textForLikes.visibility = View.VISIBLE
            promoPost.textForLikes.text = post.registeredLikes.toString()
        }

        promoPost.btnLikes.setOnClickListener {
            if (holder.adapterPosition != RecyclerView.NO_POSITION) {
                val stPost = items[holder.adapterPosition]

                stPost.likedByMe = !stPost.likedByMe

                if (post.likedByMe) {
                    post.registeredLikes = post.registeredLikes + 1
                } else {
                    post.registeredLikes = post.registeredLikes - 1
                }

                notifyItemChanged(holder.adapterPosition)
            }
        }

        when (post.commentedByMe) {
            true -> promoPost.btnComments.setBackgroundResource(R.drawable.ic_baseline_mode_comment_red_24)
            false -> promoPost.btnComments.setBackgroundResource(R.drawable.ic_baseline_mode_comment_24)
        }

        if (post.registeredComments == 0) {
            promoPost.textForComments.visibility = View.GONE
        } else {
            promoPost.textForComments.visibility = View.VISIBLE
            promoPost.textForComments.text = post.registeredComments.toString()
        }

        promoPost.btnComments.setOnClickListener {
            if (holder.adapterPosition != RecyclerView.NO_POSITION) {
                val stPost = items[holder.adapterPosition]

                stPost.commentedByMe = !stPost.commentedByMe

                if (post.commentedByMe) {
                    post.registeredComments = post.registeredComments + 1
                } else {
                    post.registeredComments = post.registeredComments - 1
                }

                notifyItemChanged(holder.adapterPosition)
            }
        }



        when (post.sharedByMe) {
            true -> promoPost.btnShares.setBackgroundResource(R.drawable.ic_baseline_share_red_24)
            false -> promoPost.btnShares.setBackgroundResource(R.drawable.ic_baseline_share_24)
        }

        if (post.registeredShares == 0) {
            promoPost.textForShares.visibility = View.GONE
        } else {
            promoPost.textForShares.visibility = View.VISIBLE
            promoPost.textForShares.text = post.registeredShares.toString()
        }

        promoPost.btnShares.setOnClickListener {

            if (holder.adapterPosition != RecyclerView.NO_POSITION) {
                val stPost = items[holder.adapterPosition]
                stPost.sharedByMe = !stPost.sharedByMe
                if (post.sharedByMe) {
                    post.registeredShares = post.registeredShares + 1

                    val intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(
                            Intent.EXTRA_TEXT,
                            """${stPost.id}
${stPost.icon}
${stPost.author}
${stPost.dateForPost}
${stPost.content}
${stPost.linkLocation}""".trimIndent()
                        )
                        type = "text/plain"
                    }
                    val context = holder.author.context
                    context.startActivity(intent)

                } else {
                    post.registeredShares = post.registeredShares - 1
                }
                notifyItemChanged(holder.adapterPosition)
            }
        }

        promoPost.imageBtnLinks.setOnClickListener {
            if (holder.adapterPosition != RecyclerView.NO_POSITION) {
                val stPost = items[holder.adapterPosition]
                val promo: Uri = Uri.parse(stPost.linkPromo)
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = promo
                }
                val context = holder.author.context
                context.startActivity(intent)
            }
        }
    }


    private fun onBindVideo(holder: RecyclerView.ViewHolder, position: Int) {
        val videoPost = holder as VideoPostUI

        val post = items[position]

        videoPost.icon.setBackgroundResource(post.icon)
        videoPost.date.text = post.dateForPost
        videoPost.author.text = post.author
        videoPost.text.text = post.content

        when (post.likedByMe) {
            true -> videoPost.btnLikes.setBackgroundResource(R.drawable.ic_baseline_favorite_red_24)
            false -> videoPost.btnLikes.setBackgroundResource(R.drawable.ic_baseline_favorite_24)
        }

        if (post.registeredLikes == 0) {
            videoPost.textForLikes.visibility = View.GONE
        } else {
            videoPost.textForLikes.visibility = View.VISIBLE
            videoPost.textForLikes.text = post.registeredLikes.toString()
        }

        videoPost.btnLikes.setOnClickListener {
            if (holder.adapterPosition != RecyclerView.NO_POSITION) {
                val stPost = items[holder.adapterPosition]

                stPost.likedByMe = !stPost.likedByMe

                if (post.likedByMe) {
                    post.registeredLikes = post.registeredLikes + 1
                } else {
                    post.registeredLikes = post.registeredLikes - 1
                }

                notifyItemChanged(holder.adapterPosition)
            }
        }

        when (post.commentedByMe) {
            true -> videoPost.btnComments.setBackgroundResource(R.drawable.ic_baseline_mode_comment_red_24)
            false -> videoPost.btnComments.setBackgroundResource(R.drawable.ic_baseline_mode_comment_24)
        }

        if (post.registeredComments == 0) {
            videoPost.textForComments.visibility = View.GONE
        } else {
            videoPost.textForComments.visibility = View.VISIBLE
            videoPost.textForComments.text = post.registeredComments.toString()
        }

        videoPost.btnComments.setOnClickListener {
            if (holder.adapterPosition != RecyclerView.NO_POSITION) {
                val stPost = items[holder.adapterPosition]

                stPost.commentedByMe = !stPost.commentedByMe

                if (post.commentedByMe) {
                    post.registeredComments = post.registeredComments + 1
                } else {
                    post.registeredComments = post.registeredComments - 1
                }

                notifyItemChanged(holder.adapterPosition)
            }
        }



        when (post.sharedByMe) {
            true -> videoPost.btnShares.setBackgroundResource(R.drawable.ic_baseline_share_red_24)
            false -> videoPost.btnShares.setBackgroundResource(R.drawable.ic_baseline_share_24)
        }

        if (post.registeredShares == 0) {
            videoPost.textForShares.visibility = View.GONE
        } else {
            videoPost.textForShares.visibility = View.VISIBLE
            videoPost.textForShares.text = post.registeredShares.toString()
        }

        videoPost.btnShares.setOnClickListener {

            if (holder.adapterPosition != RecyclerView.NO_POSITION) {
                val stPost = items[holder.adapterPosition]
                stPost.sharedByMe = !stPost.sharedByMe
                if (post.sharedByMe) {
                    post.registeredShares = post.registeredShares + 1

                    val intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(
                            Intent.EXTRA_TEXT,
                            """${stPost.id}
${stPost.icon}
${stPost.author}
${stPost.dateForPost}
${stPost.content}
${stPost.linkVideo}""".trimIndent()
                        )
                        type = "text/plain"
                    }
                    val context = holder.author.context
                    context.startActivity(intent)

                } else {
                    post.registeredShares = post.registeredShares - 1
                }
                notifyItemChanged(holder.adapterPosition)
            }
        }

        videoPost.imageBtnLinks.setOnClickListener {
            if (holder.adapterPosition != RecyclerView.NO_POSITION) {
                val stPost = items[holder.adapterPosition]
                val promo: Uri = Uri.parse(stPost.linkVideo)
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = promo
                }
                val context = holder.author.context
                context.startActivity(intent)
            }
        }
    }


    private fun onBindRePost(holder: RecyclerView.ViewHolder, position: Int) {
        val rePost = holder as RePostUI

        val post = items[position]

        rePost.icon.setBackgroundResource(post.icon)
        rePost.date.text = post.dateForPost
        rePost.author.text = post.author
        rePost.textRePost.text = post.rePostText
        rePost.iconRePost.setBackgroundResource(post.icon)
        rePost.dateRePost.text = post.dateForPost
        rePost.authorRePost.text = post.author

        when (post.likedByMe) {
            true -> rePost.btnLikes.setBackgroundResource(R.drawable.ic_baseline_favorite_red_24)
            false -> rePost.btnLikes.setBackgroundResource(R.drawable.ic_baseline_favorite_24)
        }

        if (post.registeredLikes == 0) {
            rePost.textForLikes.visibility = View.GONE
        } else {
            rePost.textForLikes.visibility = View.VISIBLE
            rePost.textForLikes.text = post.registeredLikes.toString()
        }

        rePost.btnLikes.setOnClickListener {
            if (holder.adapterPosition != RecyclerView.NO_POSITION) {
                val stPost = items[holder.adapterPosition]

                stPost.likedByMe = !stPost.likedByMe

                if (post.likedByMe) {
                    post.registeredLikes = post.registeredLikes + 1
                } else {
                    post.registeredLikes = post.registeredLikes - 1
                }

                notifyItemChanged(holder.adapterPosition)
            }
        }

        when (post.commentedByMe) {
            true -> rePost.btnComments.setBackgroundResource(R.drawable.ic_baseline_mode_comment_red_24)
            false -> rePost.btnComments.setBackgroundResource(R.drawable.ic_baseline_mode_comment_24)
        }

        if (post.registeredComments == 0) {
            rePost.textForComments.visibility = View.GONE
        } else {
            rePost.textForComments.visibility = View.VISIBLE
            rePost.textForComments.text = post.registeredComments.toString()
        }

        rePost.btnComments.setOnClickListener {
            if (holder.adapterPosition != RecyclerView.NO_POSITION) {
                val stPost = items[holder.adapterPosition]

                stPost.commentedByMe = !stPost.commentedByMe

                if (post.commentedByMe) {
                    post.registeredComments = post.registeredComments + 1
                } else {
                    post.registeredComments = post.registeredComments - 1
                }

                notifyItemChanged(holder.adapterPosition)
            }
        }



        when (post.sharedByMe) {
            true -> rePost.btnShares.setBackgroundResource(R.drawable.ic_baseline_share_red_24)
            false -> rePost.btnShares.setBackgroundResource(R.drawable.ic_baseline_share_24)
        }

        if (post.registeredShares == 0) {
            rePost.textForShares.visibility = View.GONE
        } else {
            rePost.textForShares.visibility = View.VISIBLE
            rePost.textForShares.text = post.registeredShares.toString()
        }

        rePost.btnShares.setOnClickListener {

            if (holder.adapterPosition != RecyclerView.NO_POSITION) {
                val stPost = items[holder.adapterPosition]
                stPost.sharedByMe = !stPost.sharedByMe
                if (post.sharedByMe) {
                    post.registeredShares = post.registeredShares + 1

                    val intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(
                            Intent.EXTRA_TEXT,
                            """${stPost.id}
${stPost.icon}
${stPost.author}
${stPost.dateForPost}
"Репост:"
${stPost.rePostId}
${stPost.rePostIcon}
${stPost.rePostAuthor}
${stPost.rePostDateForPost}
${stPost.rePostText}
${stPost.rePostLinkVideo}""".trimIndent()
                        )
                        type = "text/plain"
                    }
                    val context = holder.author.context
                    context.startActivity(intent)

                } else {
                    post.registeredShares = post.registeredShares - 1
                }
                notifyItemChanged(holder.adapterPosition)
            }
        }

        rePost.imageBtnLinksRePost.setOnClickListener {
            if (holder.adapterPosition != RecyclerView.NO_POSITION) {
                val stPost = items[holder.adapterPosition]
                val promo: Uri = Uri.parse(stPost.rePostLinkVideo)
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = promo
                }
                val context = holder.author.context
                context.startActivity(intent)
            }
        }
    }

    override fun getItemViewType(position: Int): Int =
        when (items[position].type) {
            Types.STANDARD_TYPE -> STANDARD_POST
            Types.EVENT_TYPE -> EVENT_POST
            Types.POST_WITH_VIDEO_TYPE -> VIDEO_POST
            Types.RE_POST_TYPE -> RE_POST
            Types.PROMOTION_TYPE -> PROMO_POST
            else -> throw IllegalArgumentException()
        }

    companion object {
        private const val STANDARD_POST = 1
        private const val EVENT_POST = 2
        private const val VIDEO_POST = 3
        private const val PROMO_POST = 4
        private const val RE_POST = 5
    }


    override fun getItemCount(): Int =
        items.count()


}